package com.bcnc.test.bcnctest.rest.mapper;

import com.bcnc.test.bcnctest.domain.ProductsInfo;
import com.bcnc.test.bcnctest.rest.dto.ProductsResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductsResponseMapper {

    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "brandId", target = "brandId")
    @Mapping(source = "feeId", target = "feeId")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "price", target = "price")
    ProductsInfo productsResponseDTOToProductsInfo(ProductsResponseDTO dto);

    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "brandId", target = "brandId")
    @Mapping(source = "feeId", target = "feeId")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "price", target = "price")
    ProductsResponseDTO productsInfoToProductsResponseDTO(ProductsInfo info);

}
