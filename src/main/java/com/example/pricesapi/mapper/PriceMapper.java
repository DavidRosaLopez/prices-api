package com.example.pricesapi.mapper;

import com.example.pricesapi.domain.PriceEntity;
import com.example.pricesapi.dto.common.Price;
import org.mapstruct.Mapper;

/** Mapper for converting PriceEntity to Price. */
@Mapper(componentModel = "spring")
public interface PriceMapper {

  /** Converts a PriceEntity to a Price DTO. */
  Price toPrice(PriceEntity price);
}
