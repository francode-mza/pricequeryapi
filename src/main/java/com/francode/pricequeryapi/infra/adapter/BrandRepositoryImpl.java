package com.francode.pricequeryapi.infra.adapter;

import com.francode.pricequeryapi.domain.model.Brand;
import com.francode.pricequeryapi.domain.port.BrandRepository;
import com.francode.pricequeryapi.infra.mapper.BrandMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BrandRepositoryImpl implements BrandRepository {

    private BrandJpaRepository repository;

    private BrandMapper brandMapper;
    public BrandRepositoryImpl(BrandJpaRepository repository, BrandMapper brandMapper) {
        this.repository = repository;
        this.brandMapper = brandMapper;
    }

    @Override
    public Optional<Brand> findById(Long id) {
        var result = repository.findById(id);

        return result.map(brandEntity -> brandMapper.toBrand(brandEntity));
    }
}
