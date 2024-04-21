package com.bcnc.test.bcnctest.data.impl;

import com.bcnc.test.bcnctest.data.PricesJPARepo;
import com.bcnc.test.bcnctest.data.entity.PricesEntity;
import com.bcnc.test.bcnctest.data.mapper.PricesRepoMapper;
import com.bcnc.test.bcnctest.domain.PricesInfo;
import com.bcnc.test.bcnctest.service.out.PricesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class PricesRepoImpl implements PricesRepository {

    private final PricesJPARepo pricesJPARepo;
    private final PricesRepoMapper pricesRepoMapper;

    @Override
    public PricesInfo findPriceInfo(PricesInfo price) {
        PricesEntity pricesEntity = pricesJPARepo.findPriceInfo(
                price.getApplicationDate(),
                price.getProductId(),
                price.getBrandId()
        );
        return pricesRepoMapper.pricesEntitytoPricesInfo(pricesEntity);
    }
}
