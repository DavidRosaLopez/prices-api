package com.example.pricesapi.controller;

import com.example.pricesapi.dto.response.RetrievePriceResponse;
import com.example.pricesapi.service.PriceService;
import com.example.pricesapi.swagger.ApiErrorResponses;
import com.example.pricesapi.swagger.ApiSuccessResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** Controller for managing prices. */
@Tag(name = "Prices", description = "Manages the prices.")
@RestController
@RequestMapping("/api/v1/prices")
@Validated
@RequiredArgsConstructor
public class PriceController {

  /** Service for managing prices. */
  private final PriceService priceService;

  /**
   * Retrieve the applicable price for a product, brand and application date.
   *
   * @param applicationDate the application date and time.
   * @param productId the product identifier.
   * @param brandId the brand identifier.
   * @return the response entity.
   */
  @Operation(summary = "Retrieve the applicable price for a product, brand and application date.")
  @ApiSuccessResponses
  @ApiErrorResponses
  @GetMapping(value = "/retrievePrice", produces = "application/json")
  public ResponseEntity<RetrievePriceResponse> retrievePrice(
      @Parameter(description = "Brand identifier.", example = "1", required = true)
          @RequestParam(name = "brandId")
          @Positive
          Long brandId,
      @Parameter(description = "Product identifier.", example = "35455", required = true)
          @RequestParam(name = "productId")
          @Positive
          Long productId,
      @Parameter(
              description = "Application date and time in ISO-8601 format.",
              example = "2020-06-14T16:00:00",
              required = true)
          @RequestParam(name = "applicationDate")
          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
          LocalDateTime applicationDate) {
    return priceService
        .retrievePrice(brandId, productId, applicationDate)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.noContent().build());
  }
}
