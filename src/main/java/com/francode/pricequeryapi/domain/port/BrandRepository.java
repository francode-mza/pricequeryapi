package com.francode.pricequeryapi.domain.port;

import com.francode.pricequeryapi.domain.model.Brand;

import java.util.Optional;

public interface BrandRepository {

    Optional<Brand> findById(Long id);
}
