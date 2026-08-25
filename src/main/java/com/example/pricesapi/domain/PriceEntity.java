package com.example.pricesapi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

/** Entity that represents a price. */
@Entity
@Table(name = "PRICES")
@Data
public class PriceEntity {

  /** The price identifier. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** The brand identifier. */
  @Column(name = "BRAND_ID", nullable = false)
  private Long brandId;

  /** The product identifier. */
  @Column(name = "PRODUCT_ID", nullable = false)
  private Long productId;

  /** The price list identifier. */
  @Column(name = "PRICE_LIST", nullable = false)
  private Integer priceList;

  /** The start date. */
  @Column(name = "START_DATE", nullable = false)
  private LocalDateTime startDate;

  /** The end date. */
  @Column(name = "END_DATE", nullable = false)
  private LocalDateTime endDate;

  /** The priority. */
  @Column(name = "PRIORITY", nullable = false)
  private Integer priority;

  /** The price. */
  @Column(name = "PRICE", nullable = false, precision = 10, scale = 2)
  private BigDecimal price;

  /** The currency. */
  @Column(name = "CURR", nullable = false, length = 3)
  private String currency;

  /** The creation date. */
  @Column(name = "CREATION_DATE", nullable = false, unique = true)
  private LocalDateTime creationDate;
}
