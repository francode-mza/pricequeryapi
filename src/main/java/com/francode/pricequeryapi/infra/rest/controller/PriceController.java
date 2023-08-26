package com.francode.pricequeryapi.infra.rest.controller;

import com.francode.pricequeryapi.domain.dto.PriceResponse;
import com.francode.pricequeryapi.infra.exception.RestRequestException;
import com.francode.pricequeryapi.service.BrandService;
import com.francode.pricequeryapi.service.PriceService;
import com.francode.pricequeryapi.service.ProductService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final PriceService priceService;

    private final ProductService productService;

    private final BrandService brandService;

    public PriceController(PriceService priceService, ProductService productService, BrandService brandService) {
        this.priceService = priceService;
        this.productService = productService;
        this.brandService = brandService;
    }

    @GetMapping()
    public ResponseEntity<Object> getPricesByCriteria(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Long brandId) {

        if (!productService.isValidProduct(productId)) {
            throw new RestRequestException(String.format("Invalid product ID: %s", productId), HttpStatus.BAD_REQUEST);
        }

        if (!brandService.isValidBrand(brandId)) {
            throw new RestRequestException(String.format("Invalid brand ID: %s", brandId), HttpStatus.BAD_REQUEST);
        }

        Optional<PriceResponse> price = priceService.getPrice(date,productId,brandId);

        if (!price.isPresent()){
            throw new RestRequestException(String.format("Price not found by requested date: %s.", date.toString()), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(price);
    }
}
