package com.example.pricesapi.service;

import com.example.pricesapi.dto.response.RetrievePriceResponse;
import com.example.pricesapi.mapper.PriceMapper;
import com.example.pricesapi.repository.PriceRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/** Service for managing prices */
@Service
@RequiredArgsConstructor
public class PriceService {

  /** Price repository */
  private final PriceRepository priceRepository;

  /** Price mapper */
  private final PriceMapper priceMapper;

  /**
   * Retrieves a price for a specific brand and product at a given date and time.
   *
   * @param applicationDate the date and time for which to retrieve the price.
   * @param productId the product identifier.
   * @param brandId the brand identifier.
   * @return the response DTO with the applicable price information.
   */
  public Optional<RetrievePriceResponse> retrievePrice(
      LocalDateTime applicationDate, Long productId, Long brandId) {
    // Llamada al repositorio para ejecutar la consulta a la base de datos, obtener el
    // precio aplicable segun los parametros de entrada y mapearlo a la respuesta final de la API
    return priceRepository
        .findApplicablePrice(brandId, productId, applicationDate)
        .map(priceMapper::toPrice)
        .map(RetrievePriceResponse::new);
  }
}
