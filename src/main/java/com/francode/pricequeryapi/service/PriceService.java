package com.francode.pricequeryapi.service;

import com.francode.pricequeryapi.domain.dto.PriceResponse;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Service interface for retrieving price information based on date, product ID, and brand ID.
 * This service provides methods to query and retrieve pricing details.
 */
public interface PriceService {

    /**
     * Retrieves the price information for a given date, product ID, and brand ID.
     *
     * @param date      The date for which the price information is requested.
     * @param productId The ID of the product for which the price information is requested.
     * @param brandId   The ID of the brand for which the price information is requested.
     * @return An Optional containing the PriceResponse if a matching price is found,
     *         or an empty Optional if no matching price is found.
     */
    Optional<PriceResponse> getPrice(LocalDateTime date, Long productId, Long brandId);
}
