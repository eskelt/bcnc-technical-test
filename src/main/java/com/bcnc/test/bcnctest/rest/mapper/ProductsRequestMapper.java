package com.bcnc.test.bcnctest.rest.mapper;

import com.bcnc.test.bcnctest.domain.ProductsInfo;
import com.bcnc.test.bcnctest.rest.dto.ProductRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductsRequestMapper {

    @Mapping(source = "applicationDate", target = "applicationDate")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "brandId", target = "brandId")
    ProductsInfo productRequestDTOToProductsInfo(ProductRequestDTO dto);

    @Mapping(source = "applicationDate", target = "applicationDate")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "brandId", target = "brandId")
    ProductRequestDTO productsInfoToProductRequestDTO(ProductsInfo info);

}
