package com.example.pricesapi.dto.common;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Record that represents a brand.
 *
 * @param brandId the brand identifier.
 */
public record Brand(@Schema(description = "Brand identifier", example = "1") Long brandId) {}
