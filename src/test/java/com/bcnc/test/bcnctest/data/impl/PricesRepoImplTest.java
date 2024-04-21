package com.bcnc.test.bcnctest.data.impl;

import com.bcnc.test.bcnctest.data.PricesJPARepo;
import com.bcnc.test.bcnctest.data.entity.BrandsEntity;
import com.bcnc.test.bcnctest.data.entity.PricesEntity;
import com.bcnc.test.bcnctest.data.mapper.PricesRepoMapper;
import com.bcnc.test.bcnctest.domain.PricesInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PricesRepoImplTest {

    @Mock
    private PricesJPARepo pricesJPARepo;

    @Mock
    private PricesRepoMapper pricesRepoMapper;

    @InjectMocks
    private PricesRepoImpl pricesRepoImpl;

    @Test
    public void testFindPriceInfo() {
        // Mock PricesEntity
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setId(1L);
        pricesEntity.setProductId(35455l);
        pricesEntity.setBrand(new BrandsEntity());
        pricesEntity.setStartDate(LocalDateTime.parse("2020-06-14T00:00:00"));
        pricesEntity.setEndDate(LocalDateTime.parse("2020-12-31T23:59:59"));
        pricesEntity.setPrice(new BigDecimal(35.5));

        // Mock PricesInfo
        PricesInfo pricesInfo = new PricesInfo();
        pricesInfo.setApplicationDate(LocalDateTime.parse("2020-06-14T10:00:00"));
        pricesInfo.setProductId(35455);
        pricesInfo.setBrandId(1);

        // Mock del comportamiento del repositorio
        when(pricesJPARepo.findPriceInfo(pricesInfo.getApplicationDate(), pricesInfo.getProductId(), pricesInfo.getBrandId()))
                .thenReturn(pricesEntity);

        // Mock del mapeo del repositorio al DTO
        when(pricesRepoMapper.pricesEntitytoPricesInfo(pricesEntity))
                .thenReturn(pricesInfo);

        // Llamada al método que queremos probar
        PricesInfo result = pricesRepoImpl.findPriceInfo(pricesInfo);

        // Comprobación de que el resultado es el esperado
        assertEquals(pricesInfo, result);
    }
}
