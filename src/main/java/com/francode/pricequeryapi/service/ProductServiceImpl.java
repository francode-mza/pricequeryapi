package com.francode.pricequeryapi.service;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Override
    public boolean isValidProduct(Long productId) {
        return false;//TODO implements after repository definition
    }
}
