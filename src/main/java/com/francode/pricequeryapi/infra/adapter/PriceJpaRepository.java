package com.francode.pricequeryapi.infra.adapter;

import com.francode.pricequeryapi.infra.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {
}
