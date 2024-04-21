package com.bcnc.test.bcnctest.service.impl;

import com.bcnc.test.bcnctest.domain.ProductsInfo;
import com.bcnc.test.bcnctest.service.in.ProductsService;
import com.bcnc.test.bcnctest.service.out.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;

    @Override
    public ProductsInfo getProduct(ProductsInfo product) {
        // Lógica para obtener la información del producto a partir de la fecha de aplicación, el ID del producto y el ID de la cadena
        return productsRepository.findProductInfo(product);
    }

}
