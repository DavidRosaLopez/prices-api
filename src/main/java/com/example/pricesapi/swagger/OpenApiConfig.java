package com.example.pricesapi.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/** OpenAPI configuration for the prices API. */
@Configuration
@OpenAPIDefinition(
    info =
        @Info(
            title = "Prices",
            description =
                """
                Manages the applicable price for a product and brand at a specific date and time.

                The service evaluates the valid price ranges, applies the business priority rules,
                and returns the matching price with product, brand, price list, validity window,
                amount, and currency information.
                """,
            version = "v1"))
public class OpenApiConfig {}
