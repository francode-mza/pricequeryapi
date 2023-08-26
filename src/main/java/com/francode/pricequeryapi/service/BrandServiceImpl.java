package com.francode.pricequeryapi.service;

import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService{
    @Override
    public boolean isValidBrand(Long brandId) {
        return false;//TODO implements after repository definition
    }
}
