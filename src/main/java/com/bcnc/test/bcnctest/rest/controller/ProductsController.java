package com.bcnc.test.bcnctest.rest.controller;

import com.bcnc.test.bcnctest.domain.ProductsInfo;
import com.bcnc.test.bcnctest.rest.api.ProductsApi;
import com.bcnc.test.bcnctest.rest.dto.ProductRequestDTO;
import com.bcnc.test.bcnctest.rest.dto.ProductsResponseDTO;
import com.bcnc.test.bcnctest.rest.mapper.ProductsRequestMapper;
import com.bcnc.test.bcnctest.rest.mapper.ProductsResponseMapper;
import com.bcnc.test.bcnctest.service.in.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductsController implements ProductsApi {

    private final ProductsService productsService;
    private final ProductsResponseMapper responseMapper;
    private final ProductsRequestMapper requestMapper;

    @Override
    public ResponseEntity<ProductsResponseDTO> getProduct(ProductRequestDTO productRequestDTO) {
        ProductsInfo productInfo = productsService.getProduct(
                requestMapper.productRequestDTOToProductsInfo(productRequestDTO));

        ProductsResponseDTO responseDTO = responseMapper.productsInfoToProductsResponseDTO(productInfo);

        return ResponseEntity.ok(responseDTO);
    }
}
