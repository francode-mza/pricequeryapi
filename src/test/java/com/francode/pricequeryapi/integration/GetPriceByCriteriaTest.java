package com.francode.pricequeryapi.integration;

import com.francode.pricequeryapi.domain.dto.PriceResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GetPriceByCriteriaTest {

    @LocalServerPort
    private int port;

    @ParameterizedTest
    @MethodSource("testData")
    public void testGetPrice(String testDate, long testProductId, long testBrandId, BigDecimal expectedPrice){
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<PriceResponse> response = restTemplate.getForEntity(createUrl(testDate,testProductId,testBrandId), PriceResponse.class);
        BigDecimal actualPrice = response.getBody().getPrice();

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(expectedPrice, actualPrice);
    }

    private String createUrl(String testDate, long testProductId, long testBrandId){
        return String.format("http://localhost:%d/prices?date=%s&productId=%d&brandId=%d", port, testDate, testProductId, testBrandId);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("2020-06-14T10:00:00", 35455L, 1L, new BigDecimal("35.50")),
                Arguments.of("2020-06-14T16:00:00", 35455L, 1L, new BigDecimal("25.45")),
                Arguments.of("2020-06-14T21:00:00", 35455L, 1L, new BigDecimal("35.50")),
                Arguments.of("2020-06-15T10:00:00", 35455L, 1L, new BigDecimal("30.50")),
                Arguments.of("2020-06-16T21:00:00", 35455L, 1L, new BigDecimal("38.95"))
        );
    }
}
