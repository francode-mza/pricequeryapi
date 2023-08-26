package com.francode.pricequeryapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceResponse {
    private Long productId;
    private Long brandId;
    private BigDecimal price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
