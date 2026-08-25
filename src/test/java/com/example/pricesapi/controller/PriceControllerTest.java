package com.example.pricesapi.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/** Controller for managing prices. */
@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

  /** MockMvc for testing. */
  @Autowired private MockMvc mockMvc;

  /** Test 1: Verifies the price at 10:00 on June 14th for product 35455 and brand 1. */
  @Test
  void test1() throws Exception {
    assertPrice("2020-06-14T10:00:00", 1, 35.50);
  }

  /** Test 2: Verifies the price at 16:00 on June 14th for product 35455 and brand 1. */
  @Test
  void test2() throws Exception {
    assertPrice("2020-06-14T16:00:00", 2, 25.45);
  }

  /** Test 3: Verifies the price at 21:00 on June 14th for product 35455 and brand 1. */
  @Test
  void test3() throws Exception {
    assertPrice("2020-06-14T21:00:00", 1, 35.50);
  }

  /** Test 4: Verifies the price at 10:00 on June 15th for product 35455 and brand 1. */
  @Test
  void test4() throws Exception {
    assertPrice("2020-06-15T10:00:00", 3, 30.50);
  }

  /** Test 5: Verifies the price at 21:00 on June 16th for product 35455 and brand 1. */
  @Test
  void test5() throws Exception {
    assertPrice("2020-06-16T21:00:00", 4, 38.95);
  }

  /** Test 6: Verifies that if two prices have the same priority, the most recent one wins. */
  @Test
  void test6() throws Exception {
    assertPrice("2020-06-15T10:40:00", 5, 31.00);
  }

  /** Test 7: Verifies the service rejects malformed parameters. */
  @Test
  void test7() throws Exception {
    mockMvc
        .perform(
            get("/api/v1/prices/retrievePrice")
                .param("applicationDate", "bad-date")
                .param("productId", "abc")
                .param("brandId", "-1"))
        .andExpect(status().isBadRequest());
  }

  /** Test 8: Verifies the service rejects requests without parameters. */
  @Test
  void test8() throws Exception {
    mockMvc.perform(get("/api/v1/prices/retrievePrice")).andExpect(status().isBadRequest());
  }

  /** Test 9: Verifies the service rejects null-like parameters. */
  @Test
  void test9() throws Exception {
    mockMvc
        .perform(
            get("/api/v1/prices/retrievePrice")
                .param("applicationDate", "null")
                .param("productId", "null")
                .param("brandId", "null"))
        .andExpect(status().isBadRequest());
  }

  /** Test 10: Verifies the service rejects out-of-range parameters. */
  @Test
  void test10() throws Exception {
    mockMvc
        .perform(
            get("/api/v1/prices/retrievePrice")
                .param("applicationDate", "2020-06-15T10:00:00")
                .param("productId", "0")
                .param("brandId", "0"))
        .andExpect(status().isBadRequest());
  }

  /** Test 11: Verifies the service rejects another malformed request. */
  @Test
  void test11() throws Exception {
    mockMvc
        .perform(
            get("/api/v1/prices/retrievePrice")
                .param("applicationDate", "2020/06/15 10:00:00")
                .param("productId", "35455")
                .param("brandId", "1"))
        .andExpect(status().isBadRequest());
  }

  /** Performs the request and verifies the returned price payload. */
  private void assertPrice(String date, int expectedPriceList, double expectedPrice)
      throws Exception {
    mockMvc
        .perform(
            get("/api/v1/prices/retrievePrice")
                .param("applicationDate", date)
                .param("productId", "35455")
                .param("brandId", "1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.price.product.productId").value(35455))
        .andExpect(jsonPath("$.price.brand.brandId").value(1))
        .andExpect(jsonPath("$.price.priceList").value(expectedPriceList))
        .andExpect(jsonPath("$.price.amount.value").value(expectedPrice))
        .andExpect(jsonPath("$.price.amount.currency").value("EUR"));
  }
}
