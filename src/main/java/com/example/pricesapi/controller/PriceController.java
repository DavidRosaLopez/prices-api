package com.example.pricesapi.controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping
public class PriceController {

    @Operation(summary = "Retrieve the applicable price for a product, brand and application date")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Price found"),
            @ApiResponse(responseCode = "204", description = "No price found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "503", description = "Service unavailable"),
            @ApiResponse(responseCode = "504", description = "Gateway timeout")
    })
    @GetMapping("/retrievePrices")
    public ResponseEntity<Void> retrievePrices(
            @Parameter(description = "Application date and time", required = true)
            @RequestParam LocalDateTime applicationDate,
            @Parameter(description = "Product identifier", required = true)
            @RequestParam Long productId,
            @Parameter(description = "Brand identifier", required = true)
            @RequestParam Long brandId) {

        return ResponseEntity.ok().build();
    }
}
