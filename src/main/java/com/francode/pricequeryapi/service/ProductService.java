package com.francode.pricequeryapi.service;

/**
 * Service interface for validating product information.
 * This service provides methods to check the validity of a product based on its ID.
 */
public interface ProductService {

    /**
     * Checks whether a product with the given ID is valid.
     *
     * @param productId The ID of the product to be validated.
     * @return `true` if the product is valid, `false` otherwise.
     */
    boolean isValidProduct(Long productId);
}
