package com.francode.pricequeryapi.service;

import com.francode.pricequeryapi.domain.port.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isValidProduct(Long productId) {
        logger.info(String.format("Validating Product with id [%d]", productId));
        return repository.findById(productId).isPresent();
    }
}
