package com.francode.pricequeryapi.service;

import com.francode.pricequeryapi.domain.dto.PriceResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService{
    @Override
    public Optional<PriceResponse> getPrice(LocalDateTime date, Long productId, Long brandId) {
        return Optional.empty();//TODO implements after repository definition
    }
}
