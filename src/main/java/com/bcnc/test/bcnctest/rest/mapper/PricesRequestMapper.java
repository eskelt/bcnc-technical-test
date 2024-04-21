package com.bcnc.test.bcnctest.rest.mapper;

import com.bcnc.test.bcnctest.domain.PricesInfo;
import com.bcnc.test.bcnctest.rest.dto.PricesRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PricesRequestMapper {

    @Mapping(source = "applicationDate", target = "applicationDate")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "brandId", target = "brandId")
    PricesInfo pricesRequestDTOToPricesInfo(PricesRequestDTO dto);

    @Mapping(source = "applicationDate", target = "applicationDate")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "brandId", target = "brandId")
    PricesRequestDTO pricesInfoToPricesRequestDTO(PricesInfo info);

}
