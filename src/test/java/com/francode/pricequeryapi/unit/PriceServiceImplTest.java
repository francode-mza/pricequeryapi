package com.francode.pricequeryapi.unit;

import com.francode.pricequeryapi.domain.dto.PriceResponse;
import com.francode.pricequeryapi.domain.model.Price;
import com.francode.pricequeryapi.domain.port.PriceRepository;
import com.francode.pricequeryapi.infra.mapper.PriceResponseMapper;
import com.francode.pricequeryapi.service.PriceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PriceServiceImplTest {

    @Mock
    private PriceRepository mockPriceRepository;

    @Mock
    private PriceResponseMapper mockPriceResponseMapper;

    @InjectMocks
    private PriceServiceImpl priceService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPrice_WhenPriceExists() {
        LocalDateTime dateTime = LocalDateTime.now();
        Long productId = 35455L;
        Long brandId = 1L;

        Price price = Price.builder()
                .startDate(dateTime)
                .endDate(dateTime.plusHours(1))
                .product(null)
                .priority(0)
                .price(BigDecimal.valueOf(35.50))
                .currency("EUR")
                .brand(null)
                .build();

        PriceResponse expectedPriceResponse = PriceResponse.builder()
                .productId(productId)
                .brandId(brandId)
                .price(price.getPrice())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .build();

        when(mockPriceRepository.findPricesByDateTimeAndProductIdAndBrandId(dateTime, productId, brandId))
                .thenReturn(Collections.singletonList(price));
        when(mockPriceResponseMapper.toPriceResponse(price)).thenReturn(expectedPriceResponse);

        Optional<PriceResponse> result = priceService.getPrice(dateTime, productId, brandId);

        assertEquals(expectedPriceResponse, result.orElse(null));
        assertEquals(productId, result.orElse(null).getProductId());
        assertEquals(brandId, result.orElse(null).getBrandId());
        assertEquals(price.getPrice(), result.orElse(null).getPrice());
        assertEquals(price.getStartDate(), result.orElse(null).getStartDate());
        assertEquals(price.getEndDate(), result.orElse(null).getEndDate());
    }

    @Test
    public void testGetPrice_WhenPriceDoesNotExist() {
        LocalDateTime dateTime = LocalDateTime.now();
        Long productId = 35455L;
        Long brandId = 1L;

        when(mockPriceRepository.findPricesByDateTimeAndProductIdAndBrandId(dateTime, productId, brandId))
                .thenReturn(Collections.emptyList());

        Optional<PriceResponse> result = priceService.getPrice(dateTime, productId, brandId);

        assertEquals(Optional.empty(), result);
    }
}

