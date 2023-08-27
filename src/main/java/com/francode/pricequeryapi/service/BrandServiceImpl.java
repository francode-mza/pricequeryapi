package com.francode.pricequeryapi.service;

import com.francode.pricequeryapi.domain.port.BrandRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService{

    private static final Logger logger = LoggerFactory.getLogger(BrandServiceImpl.class);
    private BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public boolean isValidBrand(Long brandId) {
        logger.info(String.format("Validating Brand with id [%d]", brandId));
        return brandRepository.findById(brandId).isPresent();
    }
}
