package com.example.pricesapi.repository;

import com.example.pricesapi.entity.PriceEntity;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/** Repository for managing prices. */
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

  /**
   * Retrieves the applicable price for a specific brand and product at a given date and time.
   *
   * @param brandId the brand identifier.
   * @param productId the product identifier.
   * @param startDate the start date.
   * @param endDate the end date.
   * @return the highest priority price if present.
   */
  Optional<PriceEntity>
      findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDescCreationDateDesc(
          Long brandId, Long productId, LocalDateTime startDate, LocalDateTime endDate);
}
