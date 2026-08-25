package com.example.pricesapi.dto.response;

import com.example.pricesapi.dto.common.Price;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Record that represents the response wrapper for retrieving price.
 *
 * @param price the price information
 */
public record RetrievePriceResponse(@Schema(description = "Applicable price") Price price) {}
