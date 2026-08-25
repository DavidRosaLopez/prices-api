package com.example.pricesapi.controller;

import com.example.pricesapi.dto.RetrievePriceResponse;
import com.example.pricesapi.service.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** Controller for managing prices */
@Tag(name = "Prices API", description = "API for retrieving prices")
@RestController
@RequestMapping("/api/v1/prices")
@RequiredArgsConstructor
public class PriceController {

  /** Service for managing prices */
  private final PriceService priceService;

  /**
   * Retrieve the applicable price for a product, brand and application date.
   *
   * @param applicationDate the application date and time
   * @param productId the product identifier
   * @param brandId the brand identifier
   * @return the response entity
   */
  @Operation(summary = "Retrieve the applicable price for a product, brand and application date")
  @ApiResponse(responseCode = "200", description = "Price found")
  @ApiResponse(responseCode = "204", description = "No price found")
  @ApiResponse(responseCode = "400", description = "Bad request")
  @ApiResponse(responseCode = "401", description = "Unauthorized")
  @ApiResponse(responseCode = "403", description = "Forbidden")
  @ApiResponse(responseCode = "404", description = "Not found")
  @ApiResponse(responseCode = "500", description = "Internal server error")
  @ApiResponse(responseCode = "503", description = "Service unavailable")
  @ApiResponse(responseCode = "504", description = "Gateway timeout")
  @GetMapping("/retrievePrice")
  public ResponseEntity<RetrievePriceResponse> retrievePrice(
      @Parameter(description = "Application date and time", required = true) @RequestParam
          LocalDateTime applicationDate,
      @Parameter(description = "Product identifier", required = true) @RequestParam Long productId,
      @Parameter(description = "Brand identifier", required = true) @RequestParam Long brandId) {
    return priceService
        .retrievePrice(applicationDate, productId, brandId)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.noContent().build());
  }
}
