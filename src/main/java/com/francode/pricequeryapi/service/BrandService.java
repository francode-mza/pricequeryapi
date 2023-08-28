package com.francode.pricequeryapi.service;

/**
 * Service interface for validating brand information.
 * This service provides methods to check the validity of a brand based on its ID.
 */
public interface BrandService {
    /**
     * Checks whether a brand with the given ID is valid.
     *
     * @param brandId The ID of the brand to be validated.
     * @return `true` if the brand is valid, `false` otherwise.
     */
    boolean isValidBrand(Long brandId);
}
