package com.example.pricesapi.docs.openapi;

import com.example.pricesapi.dto.response.RetrievePriceResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** Common Swagger response for successful price retrieval. */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponse(
    responseCode = "200",
    description = "Success",
    content = @Content(schema = @Schema(implementation = RetrievePriceResponse.class)))
@ApiResponse(responseCode = "204", description = "No content", content = @Content)
public @interface ApiSuccessResponse {}
