package com.example.pricesapi.dto;

/**
 * Response wrapper for retrieving price.
 *
 * @param price the price information
 */
public record RetrievePriceResponse(Price price) {}
