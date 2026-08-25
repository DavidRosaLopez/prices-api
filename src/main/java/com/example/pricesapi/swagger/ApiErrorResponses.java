package com.example.pricesapi.swagger;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.http.ProblemDetail;

/** Common Swagger responses for API errors. */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponse(
    responseCode = "400",
    description = "Bad request",
    content =
        @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ProblemDetail.class),
            examples = @ExampleObject(value = SwaggerExamples.BAD_REQUEST_ERROR)))
@ApiResponse(
    responseCode = "500",
    description = "Internal server error",
    content =
        @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ProblemDetail.class),
            examples = @ExampleObject(value = SwaggerExamples.INTERNAL_SERVER_ERROR)))
public @interface ApiErrorResponses {}
