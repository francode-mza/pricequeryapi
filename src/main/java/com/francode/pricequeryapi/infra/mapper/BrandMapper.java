package com.francode.pricequeryapi.infra.mapper;

import com.francode.pricequeryapi.domain.model.Brand;
import com.francode.pricequeryapi.infra.entity.BrandEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    Brand toBrand(BrandEntity brandEntity);

    BrandEntity toBrandEntity(Brand brand);
}
