package com.francode.pricequeryapi.infra.mapper;

import com.francode.pricequeryapi.domain.model.Product;
import com.francode.pricequeryapi.infra.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductEntity productEntity);
}
