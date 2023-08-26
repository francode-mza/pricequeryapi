package com.francode.pricequeryapi.service;

import com.francode.pricequeryapi.domain.port.ProductRepository;
import com.francode.pricequeryapi.infra.mapper.ProductMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository repository;

    private ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository repository, ProductMapper productMapper) {
        this.repository = repository;
        this.productMapper = productMapper;
    }

    @Override
    public boolean isValidProduct(Long productId) {
        return repository.findById(productId).isPresent();
    }
}
