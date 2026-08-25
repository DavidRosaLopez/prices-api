package com.example.pricesapi.swagger;

import com.example.pricesapi.dto.response.RetrievePriceResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** Common Swagger responses for success cases. */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponse(
    responseCode = "200",
    description = "OK.",
    content =
        @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = RetrievePriceResponse.class)))
@ApiResponse(responseCode = "204", description = "No Content.", content = @Content)
public @interface ApiSuccessResponses {}
