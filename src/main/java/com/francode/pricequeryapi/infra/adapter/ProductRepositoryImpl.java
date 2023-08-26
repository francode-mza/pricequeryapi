package com.francode.pricequeryapi.infra.adapter;

import com.francode.pricequeryapi.domain.model.Product;
import com.francode.pricequeryapi.domain.port.ProductRepository;
import com.francode.pricequeryapi.infra.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private ProductJpaRepository repository;

    private ProductMapper productMapper;

    public ProductRepositoryImpl(ProductJpaRepository repository, ProductMapper productMapper) {
        this.repository = repository;
        this.productMapper = productMapper;
    }


    @Override
    public Optional<Product> findById(Long productId) {
        var result = repository.findById(productId);
        return result.map(productEntity -> productMapper.toProduct(productEntity));
    }
}
