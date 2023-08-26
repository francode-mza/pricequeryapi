package com.francode.pricequeryapi.service;

import com.francode.pricequeryapi.domain.dto.PriceResponse;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceService {

    Optional<PriceResponse> getPrice(LocalDateTime date, Long productId, Long brandId);
}
