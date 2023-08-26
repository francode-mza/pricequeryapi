package com.francode.pricequeryapi.infra.adapter;

import com.francode.pricequeryapi.infra.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {

    @Query("SELECT p FROM PriceEntity p " +
            "WHERE :dateTime BETWEEN p.startDate AND p.endDate " +
            "AND p.product.id = :productId " +
            "AND p.brand.id = :brandId " +
            "ORDER BY p.priority DESC")
    public List<PriceEntity> findPricesByDateTimeAndProductIdAndBrandId(
            @Param("dateTime") LocalDateTime dateTime,
            @Param("productId") Long productId,
            @Param("brandId") Long brandId
    );
}
