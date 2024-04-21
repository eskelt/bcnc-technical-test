package com.bcnc.test.bcnctest.service.out;

import com.bcnc.test.bcnctest.domain.ProductsInfo;

public interface ProductsRepository {

    public ProductsInfo findProductInfo(ProductsInfo product);

}
