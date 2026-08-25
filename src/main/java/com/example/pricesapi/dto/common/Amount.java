package com.example.pricesapi.dto.common;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

/**
 * Record that represents an amount.
 *
 * @param value the amount value.
 * @param currency the currency of the amount.
 */
public record Amount(
    @Schema(description = "Amount value", example = "38.95") BigDecimal value,
    @Schema(description = "Currency code", example = "EUR") String currency) {}
