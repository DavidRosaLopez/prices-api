package com.example.pricesapi.service;

import com.example.pricesapi.dto.response.RetrievePriceResponse;
import com.example.pricesapi.mapper.PriceMapper;
import com.example.pricesapi.repository.PriceRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/** Service for managing prices. */
@Service
@RequiredArgsConstructor
public class PriceService {

  /** Price repository. */
  private final PriceRepository priceRepository;

  /** Price mapper. */
  private final PriceMapper priceMapper;

  /**
   * Retrieves a price for a specific brand and product at a given date and time.
   *
   * @param brandId the brand identifier.
   * @param productId the product identifier.
   * @param applicationDate the date and time for which to retrieve the price.
   * @return the response with the applicable price information.
   */
  public Optional<RetrievePriceResponse> retrievePrice(
      Long brandId, Long productId, LocalDateTime applicationDate) {
    return priceRepository
        // Llamada al metodo del repositorio para recuperar el precio aplicable.
        .findApplicablePrice(brandId, productId, applicationDate, PageRequest.of(0, 1))
        .stream()
        .findFirst()
        // Mapeo para convertir la entidad a DTO.
        .map(priceMapper::toPrice)
        // Envoltura del resultado en el objeto wrapper RetrievePriceResponse.
        .map(RetrievePriceResponse::new);
  }
}
