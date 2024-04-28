package com.bcnc.test.bcnctest.rest.controller;

import com.bcnc.test.bcnctest.domain.PricesInfo;
import com.bcnc.test.bcnctest.rest.api.PricesApi;
import com.bcnc.test.bcnctest.rest.dto.PricesRequestDTO;
import com.bcnc.test.bcnctest.rest.dto.PricesResponseDTO;
import com.bcnc.test.bcnctest.rest.exception.PriceNotFoundException;
import com.bcnc.test.bcnctest.rest.mapper.PricesRequestMapper;
import com.bcnc.test.bcnctest.rest.mapper.PricesResponseMapper;
import com.bcnc.test.bcnctest.service.in.PricesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
public class PricesController implements PricesApi {

    private final PricesService pricesService;
    private final PricesResponseMapper responseMapper;
    private final PricesRequestMapper requestMapper;

    @Override
    public ResponseEntity<PricesResponseDTO> getPrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        PricesInfo productInfo = pricesService.getPrice(
                requestMapper.pricesRequestDTOToPricesInfo(new PricesRequestDTO(applicationDate, productId, brandId)));

        if (productInfo == null) {
            throw new PriceNotFoundException("Price not found for the given request");
        }

        PricesResponseDTO responseDTO = responseMapper.pricesInfoToPricesResponseDTO(productInfo);

        return ResponseEntity.ok(responseDTO);
    }
}
