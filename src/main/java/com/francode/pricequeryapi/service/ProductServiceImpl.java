package com.francode.pricequeryapi.service;

import com.francode.pricequeryapi.domain.port.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isValidProduct(Long productId) {
        return repository.findById(productId).isPresent();
    }
}
