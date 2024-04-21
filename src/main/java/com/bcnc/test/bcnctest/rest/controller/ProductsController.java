package com.bcnc.test.bcnctest.rest.controller;

import com.bcnc.test.bcnctest.rest.api.ProductsApi;
import com.bcnc.test.bcnctest.rest.dto.ProductsResponseDTO;
import com.bcnc.test.bcnctest.service.in.ProductosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductsController implements ProductsApi {

    private final ProductosService productosService;

    @Override
    public ResponseEntity<ProductsResponseDTO> getProduct() {
        return null;
    }
}
