package com.francode.pricequeryapi.domain.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceResponse {
    private Long productId;
    private Long brandId;
    private BigDecimal price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
