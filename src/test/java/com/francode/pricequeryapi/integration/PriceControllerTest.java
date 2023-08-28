package com.francode.pricequeryapi.integration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceControllerTest {
    @LocalServerPort
    private int port;
    @ParameterizedTest
    @MethodSource("testData")
    public void testPrices(String testDate, long testProductId, long testBrandId, String expectedMessage, HttpStatus expectedHttpStatus) {
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(createUrl(testDate, testProductId, testBrandId), String.class);
        String responseBody = response.getBody();

        String actualResponseMessage = extractMessageFromResponse(responseBody);
        HttpStatus actualHttpStatus = extractHttpStatusFromResponse(responseBody);

        assertEquals(expectedHttpStatus, actualHttpStatus);
        assertEquals(expectedMessage, actualResponseMessage);
    }

    private String createUrl(String testDate, long testProductId, long testBrandId) {
        return String.format("http://localhost:%d/prices?date=%s&productId=%d&brandId=%d", port, testDate, testProductId, testBrandId);
    }

    private String extractMessageFromResponse(String responseBody) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            return jsonNode.get("message").textValue();
        } catch (Exception e) {
            throw new AssertionError("Failed to extract message from response.");
        }
    }

    private HttpStatus extractHttpStatusFromResponse(String responseBody) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            return HttpStatus.valueOf(jsonNode.get("httpStatus").textValue());
        } catch (Exception e) {
            throw new AssertionError("Failed to extract HttpStatus from response.");
        }
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("2020-06-14T16:00", 123, 1, "Invalid product ID: 123", HttpStatus.BAD_REQUEST),
                Arguments.of("2020-06-14T16:00", 35455, 123, "Invalid brand ID: 123", HttpStatus.BAD_REQUEST),
                Arguments.of("2023-06-14T16:00", 35455, 1, "Price not found by requested date: 2023-06-14T16:00.", HttpStatus.NOT_FOUND)
        );
    }
}

