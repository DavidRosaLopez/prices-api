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

  public Optional<RetrievePriceResponse> retrievePrice(
      LocalDateTime applicationDate, Long productId, Long brandId) {

    return Optional.ofNullable(
            priceRepository
                .findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDescPriceListDesc(
                    brandId, productId, applicationDate, applicationDate))
        .map(priceMapper::toPrice)
        .map(RetrievePriceResponse::new);
  }
}
