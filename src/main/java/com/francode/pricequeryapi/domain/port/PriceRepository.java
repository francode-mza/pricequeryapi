package com.francode.pricequeryapi.domain.port;

import com.francode.pricequeryapi.domain.model.Price;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface PriceRepository {

    public Iterable<Price> findPricesByDateTimeAndProductIdAndBrandId(LocalDateTime dateTime, Long productId, Long brandId);
}
