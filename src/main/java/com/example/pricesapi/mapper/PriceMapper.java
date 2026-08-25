package com.example.pricesapi.mapper;

import com.example.pricesapi.domain.PriceEntity;
import com.example.pricesapi.dto.common.Amount;
import com.example.pricesapi.dto.common.Brand;
import com.example.pricesapi.dto.common.Price;
import com.example.pricesapi.dto.common.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/** Mapper for converting PriceEntity to Price. */
@Mapper(componentModel = "spring")
public interface PriceMapper {

  /** Converts a PriceEntity to a Price DTO. */
  @Mapping(target = "product", source = "productId")
  @Mapping(target = "brand", source = "brandId")
  @Mapping(target = "amount", expression = "java(new Amount(price.getPrice(), price.getCurrency()))")
  Price toPrice(PriceEntity price);

  default Product map(Long productId) {
    return productId == null ? null : new Product(productId);
  }

  default Brand mapBrand(Long brandId) {
    return brandId == null ? null : new Brand(brandId);
  }
}
