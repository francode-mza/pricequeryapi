package com.francode.pricequeryapi.infra.config;

import com.francode.pricequeryapi.infra.mapper.PriceResponseMapper;
import com.francode.pricequeryapi.domain.port.BrandRepository;
import com.francode.pricequeryapi.domain.port.PriceRepository;
import com.francode.pricequeryapi.domain.port.ProductRepository;
import com.francode.pricequeryapi.infra.mapper.ProductMapper;
import com.francode.pricequeryapi.service.*;
import org.springframework.context.annotation.Bean;

public class BeanConfiguration {

    @Bean
    BrandService brandBeanService(final BrandRepository brandRepository){
        return new BrandServiceImpl(brandRepository);
    }

    @Bean
    ProductService productBeanService(final ProductRepository productRepository){
        return new ProductServiceImpl(productRepository);
    }

    @Bean
    PriceService priceBeanService(final PriceRepository priceRepository, final PriceResponseMapper responseMapper){
        return new PriceServiceImpl(priceRepository,responseMapper);
    }
}
