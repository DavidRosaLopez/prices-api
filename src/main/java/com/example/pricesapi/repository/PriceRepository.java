package com.example.pricesapi.repository;

import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pricesapi.domain.PriceEntity;

/**
 * Repository for managing prices
 */
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

  /**
   * Find the first by brand identifier, product identifier, start date less than or equal to, end date greater than or equal to, ordered by priority descending, price list descending.
   *
   * @param brandId             the brand identifier
   * @param productId           the product identifier
   * @param applicationDate1    the application date and time
   * @param applicationDate2    the application date and time
   * @return the first by brand identifier, product identifier, start date less than or equal to, end date greater than or equal to, ordered by priority descending, price list descending
   */
  PriceEntity findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDescPriceListDesc(
      Long brandId, Long productId, LocalDateTime applicationDate1, LocalDateTime applicationDate2);
}
