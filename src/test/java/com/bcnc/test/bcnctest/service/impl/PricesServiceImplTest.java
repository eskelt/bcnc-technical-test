package com.bcnc.test.bcnctest.service.impl;

import com.bcnc.test.bcnctest.domain.PricesInfo;
import com.bcnc.test.bcnctest.service.out.PricesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PricesServiceImplTest {

    @Mock
    private PricesRepository pricesRepository;

    @InjectMocks
    private PricesServiceImpl pricesService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetPrice() {
        // Configuración del objeto de prueba
        PricesInfo requestInfo = new PricesInfo();
        requestInfo.setApplicationDate(LocalDateTime.of(2020, 6, 14, 10, 0));
        requestInfo.setProductId(35455);
        requestInfo.setBrandId(1);

        // Mock del resultado esperado del repositorio
        PricesInfo expectedInfo = new PricesInfo();
        expectedInfo.setProductId(35455);
        expectedInfo.setBrandId(1);
        expectedInfo.setFeeId(1l);
        expectedInfo.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0));
        expectedInfo.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        expectedInfo.setPrice(new BigDecimal("35.5"));

        // Configuración del comportamiento del repositorio mock
        when(pricesRepository.findPriceInfo(requestInfo)).thenReturn(expectedInfo);

        // Ejecución del método a probar
        PricesInfo result = pricesService.getPrice(requestInfo);

        // Verificación de que el método del repositorio se llamó con los argumentos correctos
        verify(pricesRepository, times(1)).findPriceInfo(requestInfo);

        // Verificación de que el resultado es el esperado
        assertEquals(expectedInfo, result);
    }
}
