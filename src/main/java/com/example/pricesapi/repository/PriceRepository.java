package com.example.pricesapi.repository;

import com.example.pricesapi.domain.PriceEntity;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

/** Repository for managing prices */
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

  /**
   * Retrieves the applicable price for a specific brand and product at a given date and time.
   *
   * @param brandId the brand identifier.
   * @param productId the product identifier.
   * @param applicationDate the date and time for which to retrieve the price.
   * @return an optional containing the applicable price information, or an empty optional if no
   *     price is found.
   */
  @Query(
      """
              SELECT p
              FROM PriceEntity p
              WHERE p.brandId = :brandId
                AND p.productId = :productId
                AND :applicationDate BETWEEN p.startDate AND p.endDate
              ORDER BY p.priority DESC, p.startDate DESC, p.id DESC
              """)
  List<PriceEntity> findApplicablePrices(
      @Param("brandId") Long brandId,
      @Param("productId") Long productId,
      @Param("applicationDate") LocalDateTime applicationDate,
      Pageable pageable);
}
