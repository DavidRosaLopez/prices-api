package com.example.pricesapi.swagger;

import lombok.experimental.UtilityClass;

/** Utility class for Swagger examples. */
@UtilityClass
public final class SwaggerExamples {

  /** The bad request error example. */
  public static final String BAD_REQUEST_ERROR =
      "{\"type\":\"about:blank\",\"title\":\"Bad Request\",\"status\":400,\"detail\":\"Invalid request parameters\"}";

  /** The internal server error example. */
  public static final String INTERNAL_SERVER_ERROR =
      "{\"type\":\"about:blank\",\"title\":\"Internal Server Error\",\"status\":500,\"detail\":\"Internal server error\"}";
}
