package com.example.pricesapi.dto.common;

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
    Product product,
    Brand brand,
    Integer priceList,
    LocalDateTime startDate,
    LocalDateTime endDate,
    Amount amount) {}
