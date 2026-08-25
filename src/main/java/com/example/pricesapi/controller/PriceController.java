package com.example.pricesapi.controller;

import com.example.pricesapi.docs.ApiErrorResponses;
import com.example.pricesapi.docs.ApiSuccessResponse;
import com.example.pricesapi.dto.response.RetrievePriceResponse;
import com.example.pricesapi.service.PriceService;
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
import org.springframework.web.bind.annotation.RestController;

/** Controller for managing prices. */
@Tag(name = "Prices API", description = "API for retrieving prices")
@RestController
@Validated
@RequestMapping("/api/v1/prices")
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
  @Operation(summary = "Retrieve the applicable price for a product, brand and application date")
  @ApiSuccessResponse
  @ApiErrorResponses
  @GetMapping("/retrievePrice")
  public ResponseEntity<RetrievePriceResponse> retrievePrice(
      @Parameter(description = "Brand identifier", required = true) @Positive Long brandId,
      @Parameter(description = "Product identifier", required = true) @Positive Long productId,
      @Parameter(description = "Application date and time", required = true)
          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
          LocalDateTime applicationDate) {
    // Llamada al metodo del servicio para obtener el precio aplicable.
    return priceService
        .retrievePrice(brandId, productId, applicationDate)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.noContent().build());
  }
}
