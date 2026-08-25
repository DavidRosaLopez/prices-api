package com.example.pricesapi.mapper;

import org.springframework.stereotype.Component;

import com.example.pricesapi.domain.PriceEntity;
import com.example.pricesapi.dto.RetrievePriceResponse;

@Component
public class PriceMapper {

  public RetrievePriceResponse toResponse(PriceEntity price) {
    return new RetrievePriceResponse(
        price.getProductId(),
        price.getBrandId(),
        price.getPriceList(),
        price.getStartDate(),
        price.getEndDate(),
        price.getPrice());
  }
}
