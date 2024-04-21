package com.bcnc.test.bcnctest.service.out;

import com.bcnc.test.bcnctest.domain.PricesInfo;

public interface PricesRepository {

    public PricesInfo findPriceInfo(PricesInfo product);

}
