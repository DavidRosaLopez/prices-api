package com.example.pricesapi.dto.response;

import com.example.pricesapi.dto.common.Price;

/**
 * Record that represents the response wrapper for retrieving price.
 *
 * @param price the price information
 */
public record RetrievePriceResponse(Price price) {}
