package com.francode.pricequeryapi.domain.port;

import com.francode.pricequeryapi.domain.model.Product;

import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(Long productId);
}
