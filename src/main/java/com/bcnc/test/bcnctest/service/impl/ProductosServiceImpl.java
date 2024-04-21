package com.bcnc.test.bcnctest.service.impl;

import com.bcnc.test.bcnctest.service.in.ProductosService;
import com.bcnc.test.bcnctest.service.out.ProductosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductosServiceImpl implements ProductosService {

    private final ProductosRepository productosRepository;

}
