package com.francode.pricequeryapi.infra.adapter;

import com.francode.pricequeryapi.infra.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandJpaRepository extends JpaRepository<BrandEntity, Long> {
}
