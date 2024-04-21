package com.bcnc.test.bcnctest.service.impl;

import com.bcnc.test.bcnctest.domain.PricesInfo;
import com.bcnc.test.bcnctest.service.in.PricesService;
import com.bcnc.test.bcnctest.service.out.PricesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PricesServiceImpl implements PricesService {

    private final PricesRepository pricesRepository;

    @Override
    public PricesInfo getPrice(PricesInfo product) {
        // Lógica para obtener la información del producto a partir de la fecha de aplicación, el ID del producto y el ID de la cadena
        return pricesRepository.findPriceInfo(product);
    }

}
