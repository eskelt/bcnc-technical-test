package com.bcnc.test.bcnctest.data.mapper;
import com.bcnc.test.bcnctest.data.entity.PricesEntity;
import com.bcnc.test.bcnctest.domain.PricesInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PricesRepoMapper {

    @Mapping(target = "brandId", source = "entity.brand.id")
    @Mapping(target = "startDate", source = "entity.startDate")
    @Mapping(target = "endDate", source = "entity.endDate")
    @Mapping(target = "feeId", source = "entity.priceList")
    @Mapping(target = "productId", source = "entity.productId")
    @Mapping(target = "priority", source = "entity.priority")
    @Mapping(target = "price", source = "entity.price")
    @Mapping(target = "currency", source = "entity.currency")
    PricesInfo pricesEntitytoPricesInfo(PricesEntity entity);

    @Mapping(target = "brand.id", source = "domain.brandId")
    @Mapping(target = "startDate", source = "domain.startDate")
    @Mapping(target = "endDate", source = "domain.endDate")
    @Mapping(target = "priceList", source = "domain.feeId")
    @Mapping(target = "productId", source = "domain.productId")
    @Mapping(target = "priority", source = "domain.priority")
    @Mapping(target = "price", source = "domain.price")
    @Mapping(target = "currency", source = "domain.currency")
    PricesEntity pricesInfotoPricesEntity(PricesInfo domain);

}
