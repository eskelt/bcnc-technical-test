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

@RequiredArgsConstructor
@RestController
public class PricesController implements PricesApi {

    private final PricesService pricesService;
    private final PricesResponseMapper responseMapper;
    private final PricesRequestMapper requestMapper;

    @Override
    public ResponseEntity<PricesResponseDTO> getPrice(PricesRequestDTO pricesRequestDTO) {
        PricesInfo productInfo = pricesService.getPrice(
                requestMapper.pricesRequestDTOToPricesInfo(pricesRequestDTO));

        if (productInfo == null) {
            throw new PriceNotFoundException("Price not found for the given request");
        }

        PricesResponseDTO responseDTO = responseMapper.pricesInfoToPricesResponseDTO(productInfo);

        return ResponseEntity.ok(responseDTO);
    }
}
