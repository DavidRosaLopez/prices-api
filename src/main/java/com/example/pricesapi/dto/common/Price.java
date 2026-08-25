package com.example.pricesapi.dto.common;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Price data returned by the API.
 *
 * @param productId the product identifier
 * @param brandId the brand identifier
 * @param priceList the price list identifier
 * @param startDate the start date
 * @param endDate the end date
 * @param price the final price
 */
public record Price(
    Long productId,
    Long brandId,
    Integer priceList,
    LocalDateTime startDate,
    LocalDateTime endDate,
    BigDecimal price) {}
