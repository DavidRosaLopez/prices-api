package com.example.pricesapi.dto.common;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

/**
 * Record that represents a price.
 *
 * @param product the product information
 * @param brand the brand information
 * @param priceList the price list identifier
 * @param startDate the start date
 * @param endDate the end date
 * @param amount the amount information
 */
public record Price(
    @Schema(description = "Product information") Product product,
    @Schema(description = "Brand information") Brand brand,
    @Schema(description = "Price list identifier", example = "4") Integer priceList,
    @Schema(description = "Start date", example = "2020-06-15T16:00:00") LocalDateTime startDate,
    @Schema(description = "End date", example = "2020-12-31T23:59:59") LocalDateTime endDate,
    @Schema(description = "Amount information") Amount amount) {}
