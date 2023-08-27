package com.francode.pricequeryapi.infra.mapper;

import com.francode.pricequeryapi.domain.model.Price;
import com.francode.pricequeryapi.infra.entity.PriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    Price toPrice(PriceEntity priceEntity);
    Iterable<Price> toPrices(Iterable<PriceEntity> priceEntities);
}
