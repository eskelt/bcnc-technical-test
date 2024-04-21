package com.bcnc.test.bcnctest.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductsInfo {
    private LocalDateTime applicationDate;
    private Integer productId;
    private Integer brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long feeId;
    private int priority;
    private BigDecimal price;
    private String currency;
}