package com.example.pricesapi.dto.common;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Record that represents a product.
 *
 * @param productId the product identifier.
 */
public record Product(
    @Schema(description = "Product identifier", example = "35455") Long productId) {}
