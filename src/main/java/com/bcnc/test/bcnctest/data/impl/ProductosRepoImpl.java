package com.bcnc.test.bcnctest.data.impl;

import com.bcnc.test.bcnctest.data.ProductosJPARepo;
import com.bcnc.test.bcnctest.service.out.ProductosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ProductosRepoImpl implements ProductosRepository {

    private final ProductosJPARepo productosJPARepo;

}
