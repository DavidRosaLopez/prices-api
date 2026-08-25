package com.example.pricesapi.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

/** Record that represents the error response structure. */
public record ErrorResponse(
    @Schema(description = "Error code", example = "400") String code,
    @Schema(description = "Error description", example = "Invalid request parameter")
        String description) {}
