package com.example.pricesapi.repository;

import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pricesapi.domain.PriceEntity;

/** Repository for managing prices */
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

  /**
   * Find the first price for a brand and product at a given date.
   *
   * @param brandId the brand identifier
   * @param productId the product identifier
   * @param applicationDate1 the application date and time
   * @param applicationDate2 the application date and time
   * @return the price entity
   */
  PriceEntity
      findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDescPriceListDesc(
          Long brandId,
          Long productId,
          LocalDateTime applicationDate1,
          LocalDateTime applicationDate2);
}
