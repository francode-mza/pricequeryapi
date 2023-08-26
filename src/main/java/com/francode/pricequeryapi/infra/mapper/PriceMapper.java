package com.francode.pricequeryapi.infra.mapper;

import com.francode.pricequeryapi.domain.model.Price;
import com.francode.pricequeryapi.infra.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    Price toPrice(PriceEntity priceEntity);
    PriceEntity toPriceEntity(Price price);
    Iterable<Price> toPrices(Iterable<PriceEntity> priceEntities);
    Iterable<PriceEntity> toPriceEntities(Iterable<Price> priceEntities);
}
