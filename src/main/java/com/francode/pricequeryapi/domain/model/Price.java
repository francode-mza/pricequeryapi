package com.francode.pricequeryapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class Price {
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Product product;
    private Long priority;
    private BigDecimal price;
    private String currency;
    private Brand brand;
}
