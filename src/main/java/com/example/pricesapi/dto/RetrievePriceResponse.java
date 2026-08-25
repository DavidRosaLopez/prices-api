package com.example.pricesapi.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RetrievePriceResponse(
    Long productId,
    Long brandId,
    Integer priceList,
    LocalDateTime startDate,
    LocalDateTime endDate,
    BigDecimal price) {}
