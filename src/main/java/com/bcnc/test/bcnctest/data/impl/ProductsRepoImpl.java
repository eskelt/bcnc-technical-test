package com.bcnc.test.bcnctest.data.impl;

import com.bcnc.test.bcnctest.data.ProductosJPARepo;
import com.bcnc.test.bcnctest.data.entity.ProductsEntity;
import com.bcnc.test.bcnctest.data.mapper.ProductsRepoMapper;
import com.bcnc.test.bcnctest.domain.ProductsInfo;
import com.bcnc.test.bcnctest.service.out.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ProductsRepoImpl implements ProductsRepository {

    private final ProductosJPARepo productosJPARepo;
    private final ProductsRepoMapper productsRepoMapper;

    @Override
    public ProductsInfo findProductInfo(ProductsInfo product) {
        ProductsEntity productsEntity = productosJPARepo.findProductInfo(
                product.getApplicationDate(),
                product.getProductId(),
                product.getBrandId()
        );
        return productsRepoMapper.productsEntitytoProductsInfo(productsEntity);
    }
}
