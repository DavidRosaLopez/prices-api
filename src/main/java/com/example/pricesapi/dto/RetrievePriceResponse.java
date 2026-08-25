package com.example.pricesapi.dto;

/**
 * Response wrapper for retrieving price.
 *
 * @param price the price payload
 */
public record RetrievePriceResponse(Price price) {}
