package com.francode.pricequeryapi.infra.mapper;

import com.francode.pricequeryapi.domain.dto.PriceResponse;
import com.francode.pricequeryapi.domain.model.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceResponseMapper {
    PriceResponse toPriceResponse(Price price);
}
