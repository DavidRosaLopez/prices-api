package com.example.pricesapi.swagger;

import lombok.experimental.UtilityClass;

/** Utility class for Swagger examples. */
@UtilityClass
public final class SwaggerExamples {

  /** The bad request error example. */
  public static final String BAD_REQUEST_ERROR =
      "{\"detail\":\"Invalid request parameters\",\"instance\":\"/api/v1/prices/retrievePrice\",\"status\":400,\"title\":\"Bad Request\"}";

  /** The internal server error example. */
  public static final String INTERNAL_SERVER_ERROR =
      "{\"detail\":\"Internal server error\",\"instance\":\"/api/v1/prices/retrievePrice\",\"status\":500,\"title\":\"Internal Server Error\"}";
}
