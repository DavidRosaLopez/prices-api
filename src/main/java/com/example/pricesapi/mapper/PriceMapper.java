package com.example.pricesapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.pricesapi.domain.PriceEntity;
import com.example.pricesapi.dto.RetrievePriceResponse;

/** Mapper for converting PriceEntity to RetrievePriceResponse. */
@Mapper(componentModel = "spring")
public interface PriceMapper {

  /** Converts a PriceEntity to a RetrievePriceResponse. */
  @Mapping(target = "productId", source = "productId")
  @Mapping(target = "brandId", source = "brandId")
  @Mapping(target = "priceList", source = "priceList")
  @Mapping(target = "startDate", source = "startDate")
  @Mapping(target = "endDate", source = "endDate")
  @Mapping(target = "price", source = "price")
  RetrievePriceResponse toResponse(PriceEntity price);
}
