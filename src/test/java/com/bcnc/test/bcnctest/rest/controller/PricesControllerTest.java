package com.bcnc.test.bcnctest.rest.controller;

import com.bcnc.test.bcnctest.domain.PricesInfo;
import com.bcnc.test.bcnctest.rest.dto.PricesRequestDTO;
import com.bcnc.test.bcnctest.rest.dto.PricesResponseDTO;
import com.bcnc.test.bcnctest.rest.mapper.PricesRequestMapper;
import com.bcnc.test.bcnctest.rest.mapper.PricesResponseMapper;
import com.bcnc.test.bcnctest.service.in.PricesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PricesControllerTest {

    @Mock
    private PricesService pricesService;

    @Mock
    private PricesResponseMapper responseMapper;

    @Mock
    private PricesRequestMapper requestMapper;

    @InjectMocks
    private PricesController pricesController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetPrice() {
        // Configuración del objeto de solicitud
        PricesRequestDTO requestDTO = new PricesRequestDTO();
        PricesInfo requestInfo = new PricesInfo(); // Puede ser un mock si es necesario

        // Mock del resultado esperado del servicio
        PricesInfo expectedInfo = new PricesInfo();
        PricesResponseDTO expectedResponseDTO = new PricesResponseDTO();

        // Configuración del comportamiento del servicio mock
        when(requestMapper.pricesRequestDTOToPricesInfo(requestDTO)).thenReturn(requestInfo);
        when(pricesService.getPrice(requestInfo)).thenReturn(expectedInfo);
        when(responseMapper.pricesInfoToPricesResponseDTO(expectedInfo)).thenReturn(expectedResponseDTO);

        // Ejecución del método a probar
        ResponseEntity<PricesResponseDTO> responseEntity = pricesController.getPrice(requestDTO);

        // Verificación de que el servicio y el mapper se llamaron con los argumentos correctos
        verify(requestMapper, times(1)).pricesRequestDTOToPricesInfo(requestDTO);
        verify(pricesService, times(1)).getPrice(requestInfo);
        verify(responseMapper, times(1)).pricesInfoToPricesResponseDTO(expectedInfo);

        // Verificación del código de estado y el cuerpo de la respuesta
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponseDTO, responseEntity.getBody());
    }
}
