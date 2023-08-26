package com.francode.pricequeryapi.service;

import com.francode.pricequeryapi.domain.dto.PriceResponse;
import com.francode.pricequeryapi.domain.port.PriceRepository;
import com.francode.pricequeryapi.infra.mapper.PriceMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService{

    private PriceRepository repository;

    private PriceMapper priceMapper;

    public PriceServiceImpl(PriceRepository repository, PriceMapper priceMapper) {
        this.repository = repository;
        this.priceMapper = priceMapper;
    }

    @Override
    public Optional<PriceResponse> getPrice(LocalDateTime date, Long productId, Long brandId) {
        return Optional.empty();//TODO implements after repository definition
    }
}
