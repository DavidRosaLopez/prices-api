package com.example.pricesapi.dto.common;

import java.math.BigDecimal;

/**
 * Record that represents an amount.
 *
 * @param value the amount value.
 * @param currency the currency of the amount.
 */
public record Amount(BigDecimal value, String currency) {}
