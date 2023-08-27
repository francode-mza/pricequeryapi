package com.francode.pricequeryapi.unit;

import com.francode.pricequeryapi.domain.dto.PriceResponse;
import com.francode.pricequeryapi.domain.model.Price;
import com.francode.pricequeryapi.domain.model.Product;
import com.francode.pricequeryapi.domain.model.Brand;
import com.francode.pricequeryapi.infra.mapper.PriceResponseMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PriceResponseMapperTest {

    private final PriceResponseMapper priceResponseMapper = Mappers.getMapper(PriceResponseMapper.class);

    @Mock
    private Product mockProduct;

    @Mock
    private Brand mockBrand;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testToPriceResponse() {
        Long productId = 35455L;
        Long brandId = 1L;

        when(mockProduct.getId()).thenReturn(productId);
        when(mockBrand.getId()).thenReturn(brandId);

        Price price = Price.builder()
                .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
                .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
                .product(mockProduct)
                .priority(0)
                .price(BigDecimal.valueOf(35.50))
                .currency("EUR")
                .brand(mockBrand)
                .build();

        PriceResponse priceResponse = priceResponseMapper.toPriceResponse(price);

        assertEquals(price.getStartDate(), priceResponse.getStartDate());
        assertEquals(price.getEndDate(), priceResponse.getEndDate());
        assertEquals(price.getPrice(), priceResponse.getPrice());
    //    assertEquals(price.getCurrency(), priceResponse.getCurrency());
        assertEquals(productId, priceResponse.getProductId());
        assertEquals(brandId, priceResponse.getBrandId());
    }
}
