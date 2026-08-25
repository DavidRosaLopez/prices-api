package com.example.pricesapi.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Response DTO for retrieving price.
 *
 * @param productId the product identifier
 * @param brandId the brand identifier
 * @param priceList the price list identifier
 * @param startDate the start date
 * @param endDate the end date
 * @param price the price
 */
public record RetrievePriceResponse(
    Long productId,
    Long brandId,
    Integer priceList,
    LocalDateTime startDate,
    LocalDateTime endDate,
    BigDecimal price) {}
