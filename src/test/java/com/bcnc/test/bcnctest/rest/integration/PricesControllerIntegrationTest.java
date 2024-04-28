package com.bcnc.test.bcnctest.rest.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class PricesControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testPriceEndpointCall1() throws Exception {
        performAndVerify("2020-06-14T10:00:00", "35455", "1", "2020-06-14T00:00:00", "2020-12-31T23:59:59", 35.5);
    }

    @Test
    void testPriceEndpointCall2() throws Exception {
        performAndVerify("2020-06-14T16:00:00", "35455", "1", "2020-06-14T15:00:00", "2020-06-14T18:30:00", 25.45);
    }

    @Test
    void testPriceEndpointCall3() throws Exception {
        performAndVerify("2020-06-14T21:00:00", "35455", "1", "2020-06-14T00:00:00", "2020-12-31T23:59:59", 35.5);
    }

    @Test
    void testPriceEndpointCall4() throws Exception {
        performAndVerify("2020-06-15T10:00:00", "35455", "1", "2020-06-15T00:00:00", "2020-06-15T11:00:00", 30.5);
    }

    @Test
    void testPriceEndpointCall5() throws Exception {
        performAndVerify("2020-06-16T21:00:00", "35455", "1", "2020-06-15T16:00:00", "2020-12-31T23:59:59", 38.95);
    }

    private void performAndVerify(String applicationDate, String productId, String brandId, String expectedStartDate, String expectedEndDate, double expectedPrice) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/prices")
                        .param("applicationDate", applicationDate)
                        .param("productId", productId)
                        .param("brandId", brandId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.startDate").value(expectedStartDate))
                .andExpect(jsonPath("$.endDate").value(expectedEndDate))
                .andExpect(jsonPath("$.price").value(expectedPrice));
    }
}
