package com.example.pricesapi.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

/** OpenAPI configuration for the prices API. */
@Configuration
@OpenAPIDefinition(
    info =
        @Info(
            title = "Prices",
            description =
                """
                Allows managing prices for a product and brand.

                The service evaluates the valid price ranges, applies the business priority rules,
                and returns the matching price with product, brand, price list, validity window,
                amount and currency information.
                """,
            version = "v1",
            license =
                @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0"),
            contact = @Contact(name = "David", email = "davorsevilla@hotmail.com")))
public class OpenApiConfig {}
