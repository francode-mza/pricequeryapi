package com.francode.pricequeryapi.unit;

import com.francode.pricequeryapi.domain.model.Price;
import com.francode.pricequeryapi.infra.entity.BrandEntity;
import com.francode.pricequeryapi.infra.entity.PriceEntity;
import com.francode.pricequeryapi.infra.entity.ProductEntity;
import com.francode.pricequeryapi.infra.mapper.PriceMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PriceMapperTest {

    @Mock
    private ProductEntity mockProductEntity;

    @Mock
    private BrandEntity mockBrandEntity;

    @InjectMocks
    private PriceMapper priceMapper = Mappers.getMapper(PriceMapper.class);

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testToPrice() {
        PriceEntity priceEntity = PriceEntity.builder()
                .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
                .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
                .product(mockProductEntity)
                .priority(0)
                .price(BigDecimal.valueOf(35.50))
                .currency("EUR")
                .brand(mockBrandEntity)
                .build();

        var productId = 35455L;
        var brandId = 1L;
        when(mockProductEntity.getId()).thenReturn(productId);
        when(mockBrandEntity.getId()).thenReturn(brandId);

        Price price = priceMapper.toPrice(priceEntity);

        assertEquals(priceEntity.getId(), price.getId());
        assertEquals(priceEntity.getStartDate(), price.getStartDate());
        assertEquals(priceEntity.getEndDate(), price.getEndDate());
        assertEquals(priceEntity.getPriority(), price.getPriority());
        assertEquals(priceEntity.getPrice(), price.getPrice());
        assertEquals(priceEntity.getCurrency(), price.getCurrency());
        assertEquals(priceEntity.getProduct().getId(), productId);
        assertEquals(priceEntity.getBrand().getId(), brandId);
    }
}
