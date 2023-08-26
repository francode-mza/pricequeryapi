package com.francode.pricequeryapi.infra.mapper;

import com.francode.pricequeryapi.domain.dto.PriceResponse;
import com.francode.pricequeryapi.domain.model.Brand;
import com.francode.pricequeryapi.domain.model.Price;
import com.francode.pricequeryapi.domain.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceResponseMapper {
    PriceResponse toPriceResponse(Price price);

    default Long mapProductToProductId(Product product) {
        return product != null ? product.getId() : null;
    }

    default Long mapBrandToBrandId(Brand brand) {
        return brand != null ? brand.getId() : null;

    }
}
