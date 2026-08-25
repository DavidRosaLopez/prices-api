package com.example.pricesapi.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/** Controller for managing prices */
@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

  /** MockMvc for testing */
  @Autowired private MockMvc mockMvc;

  /** Verifies the price at 10:00 on June 14th for product 35455 and brand 1. */
  @Test
  void test1() throws Exception {
    assertPrice("2020-06-14T10:00:00", 1, 35.50);
  }

  /** Verifies the price at 16:00 on June 14th for product 35455 and brand 1. */
  @Test
  void test2() throws Exception {
    assertPrice("2020-06-14T16:00:00", 2, 25.45);
  }

  /** Verifies the price at 21:00 on June 14th for product 35455 and brand 1. */
  @Test
  void test3() throws Exception {
    assertPrice("2020-06-14T21:00:00", 1, 35.50);
  }

  /** Verifies the price at 10:00 on June 15th for product 35455 and brand 1. */
  @Test
  void test4() throws Exception {
    assertPrice("2020-06-15T10:00:00", 3, 30.50);
  }

  /**
   * Test 5: Verifies the price at 21:00 on June 16th for product 35455 and brand 1.
   */
  @Test
  void test5() throws Exception {
    assertPrice("2020-06-16T21:00:00", 4, 38.95);
  }

  /** Performs the request and verifies the returned price payload. */
  private void assertPrice(String applicationDate, int expectedPriceList, double expectedPrice)
      throws Exception {
    mockMvc
        .perform(
            get("/api/v1/prices/retrievePrices")
                .param("applicationDate", applicationDate)
                .param("productId", "35455")
                .param("brandId", "1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.productId").value(35455))
        .andExpect(jsonPath("$.brandId").value(1))
        .andExpect(jsonPath("$.priceList").value(expectedPriceList))
        .andExpect(jsonPath("$.price").value(expectedPrice));
  }
}
