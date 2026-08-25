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
  @Mapping(target = "amount", source = ".")
  Price toPrice(PriceEntity price);

  /** Maps a Long to a Product DTO. */
  default Product toProduct(Long productId) {
    return productId == null ? null : new Product(productId);
  }

  /** Maps a Long to a Brand DTO. */
  default Brand toBrand(Long brandId) {
    return brandId == null ? null : new Brand(brandId);
  }

  /** Maps a PriceEntity to an Amount DTO. */
  default Amount mapAmount(PriceEntity price) {
    return price == null ? null : new Amount(price.getPrice(), price.getCurrency());
  }
}
