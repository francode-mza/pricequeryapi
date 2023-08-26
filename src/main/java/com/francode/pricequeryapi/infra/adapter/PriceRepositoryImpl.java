package com.francode.pricequeryapi.infra.adapter;

import com.francode.pricequeryapi.domain.model.Price;
import com.francode.pricequeryapi.domain.port.PriceRepository;
import com.francode.pricequeryapi.infra.entity.PriceEntity;
import com.francode.pricequeryapi.infra.mapper.PriceMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PriceRepositoryImpl implements PriceRepository {

    private final PriceJpaRepository jpaRepository;

    private final PriceMapper priceMapper;

    public PriceRepositoryImpl(PriceJpaRepository jpaRepository, PriceMapper priceMapper) {
        this.jpaRepository = jpaRepository;
        this.priceMapper = priceMapper;
    }

    public Iterable<Price> findPricesByDateTimeAndProductIdAndBrandId(
            @Param("dateTime") LocalDateTime dateTime,
            @Param("productId") Long productId,
            @Param("brandId") Long brandId
    ){
        List<PriceEntity> prices = jpaRepository.findPricesByDateTimeAndProductIdAndBrandId(dateTime,productId,brandId);
        return priceMapper.toPrices(prices);
    }
}
