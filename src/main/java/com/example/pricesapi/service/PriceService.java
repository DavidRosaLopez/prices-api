package com.example.pricesapi.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.pricesapi.domain.PriceEntity;
import com.example.pricesapi.dto.RetrievePriceResponse;
import com.example.pricesapi.mapper.PriceMapper;
import com.example.pricesapi.repository.PriceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PriceService {

  private final PriceRepository priceRepository;
  private final PriceMapper priceMapper;

  public Optional<RetrievePriceResponse> retrievePrice(
      LocalDateTime applicationDate, Long productId, Long brandId) {

    return Optional.ofNullable(
        priceRepository
            .findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDescPriceListDesc(
                brandId, productId, applicationDate, applicationDate))
        .map(priceMapper::toResponse);
  }
}
