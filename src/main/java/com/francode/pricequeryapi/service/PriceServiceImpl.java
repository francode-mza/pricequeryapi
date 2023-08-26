package com.francode.pricequeryapi.service;

import com.francode.pricequeryapi.domain.dto.PriceResponse;
import com.francode.pricequeryapi.infra.mapper.PriceResponseMapper;
import com.francode.pricequeryapi.domain.model.Price;
import com.francode.pricequeryapi.domain.port.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService{

    private PriceRepository repository;

    private PriceResponseMapper priceResponseMapper;

    public PriceServiceImpl(PriceRepository repository, PriceResponseMapper priceResponseMapper) {
        this.repository = repository;
        this.priceResponseMapper = priceResponseMapper;
    }

    @Override
    public Optional<PriceResponse> getPrice(LocalDateTime date, Long productId, Long brandId) {
        Iterable<Price> prices = repository.findPricesByDateTimeAndProductIdAndBrandId(date,productId,brandId);
        if (!prices.iterator().hasNext()){
            return Optional.empty();
        }else{
            return Optional.of(priceResponseMapper.toPriceResponse(prices.iterator().next()));
        }

    }
}
