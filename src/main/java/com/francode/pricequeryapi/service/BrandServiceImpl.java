package com.francode.pricequeryapi.service;

import com.francode.pricequeryapi.domain.port.BrandRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService{
    private BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public boolean isValidBrand(Long brandId) {
        return brandRepository.findById(brandId).isPresent();
    }
}
