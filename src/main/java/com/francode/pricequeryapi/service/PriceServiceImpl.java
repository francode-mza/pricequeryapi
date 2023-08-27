package com.francode.pricequeryapi.service;

import com.francode.pricequeryapi.domain.dto.PriceResponse;
import com.francode.pricequeryapi.infra.mapper.PriceResponseMapper;
import com.francode.pricequeryapi.domain.model.Price;
import com.francode.pricequeryapi.domain.port.PriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService{
    private static final Logger logger = LoggerFactory.getLogger(PriceServiceImpl.class);
    private PriceRepository repository;

    private PriceResponseMapper priceResponseMapper;

    public PriceServiceImpl(PriceRepository repository, PriceResponseMapper priceResponseMapper) {
        this.repository = repository;
        this.priceResponseMapper = priceResponseMapper;
    }

    @Override
    public Optional<PriceResponse> getPrice(LocalDateTime date, Long productId, Long brandId) {
        logger.info(String.format("Searching for price: Product ID [%d], Brand ID [%d], Date [%s]", productId, brandId, date));
        Iterable<Price> prices = repository.findPricesByDateTimeAndProductIdAndBrandId(date,productId,brandId);
        if (!prices.iterator().hasNext()){
            logger.info("No price found for the given criteria.");
            return Optional.empty();
        }else{
            return Optional.of(priceResponseMapper.toPriceResponse(prices.iterator().next()));
        }

    }
}
