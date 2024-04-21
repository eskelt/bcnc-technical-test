package com.bcnc.test.bcnctest.rest.controller;

import com.bcnc.test.bcnctest.service.in.ProductosService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductsController {

    private final ProductosService productosService;

}
