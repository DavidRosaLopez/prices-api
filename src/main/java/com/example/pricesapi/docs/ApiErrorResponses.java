package com.example.pricesapi.docs;

import com.example.pricesapi.dto.response.ErrorResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** Common Swagger responses for API errors. */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponse(
    responseCode = "400",
    description = "Bad request",
    content =
        @Content(
            schema = @Schema(implementation = ErrorResponse.class),
            examples =
                @ExampleObject(name = "Bad request", value = SwaggerExamples.BAD_REQUEST_ERROR)))
@ApiResponse(
    responseCode = "401",
    description = "Unauthorized",
    content =
        @Content(
            schema = @Schema(implementation = ErrorResponse.class),
            examples =
                @ExampleObject(name = "Unauthorized", value = SwaggerExamples.UNAUTHORIZED_ERROR)))
@ApiResponse(
    responseCode = "403",
    description = "Forbidden",
    content =
        @Content(
            schema = @Schema(implementation = ErrorResponse.class),
            examples = @ExampleObject(name = "Forbidden", value = SwaggerExamples.FORBIDDEN_ERROR)))
@ApiResponse(
    responseCode = "404",
    description = "Not found",
    content =
        @Content(
            schema = @Schema(implementation = ErrorResponse.class),
            examples = @ExampleObject(name = "Not found", value = SwaggerExamples.NOT_FOUND_ERROR)))
@ApiResponse(
    responseCode = "500",
    description = "Internal server error",
    content =
        @Content(
            schema = @Schema(implementation = ErrorResponse.class),
            examples =
                @ExampleObject(
                    name = "Internal server error",
                    value = SwaggerExamples.INTERNAL_SERVER_ERROR)))
@ApiResponse(
    responseCode = "503",
    description = "Service unavailable",
    content =
        @Content(
            schema = @Schema(implementation = ErrorResponse.class),
            examples =
                @ExampleObject(
                    name = "Service unavailable",
                    value = SwaggerExamples.SERVICE_UNAVAILABLE_ERROR)))
@ApiResponse(
    responseCode = "504",
    description = "Gateway timeout",
    content =
        @Content(
            schema = @Schema(implementation = ErrorResponse.class),
            examples =
                @ExampleObject(
                    name = "Gateway timeout",
                    value = SwaggerExamples.GATEWAY_TIMEOUT_ERROR)))
public @interface ApiErrorResponses {}
