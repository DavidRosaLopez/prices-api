package com.example.pricesapi.swagger;

import lombok.experimental.UtilityClass;

/** Utility class for Swagger examples. */
@UtilityClass
public final class SwaggerExamples {

  /** The bad request error example. */
  public static final String BAD_REQUEST_ERROR =
      "{\"type\":\"about:blank\",\"title\":\"Bad Request\",\"status\":400,\"detail\":\"Invalid request parameters\"}";

  /** The unauthorized error example. */
  public static final String UNAUTHORIZED_ERROR =
      "{\"type\":\"about:blank\",\"title\":\"Unauthorized\",\"status\":401,\"detail\":\"Unauthorized\"}";

  /** The forbidden error example. */
  public static final String FORBIDDEN_ERROR =
      "{\"type\":\"about:blank\",\"title\":\"Forbidden\",\"status\":403,\"detail\":\"Forbidden\"}";

  /** The not found error example. */
  public static final String NOT_FOUND_ERROR =
      "{\"type\":\"about:blank\",\"title\":\"Not Found\",\"status\":404,\"detail\":\"Price not found\"}";

  /** The internal server error example. */
  public static final String INTERNAL_SERVER_ERROR =
      "{\"type\":\"about:blank\",\"title\":\"Internal Server Error\",\"status\":500,\"detail\":\"Internal server error\"}";

  /** The service unavailable error example. */
  public static final String SERVICE_UNAVAILABLE_ERROR =
      "{\"type\":\"about:blank\",\"title\":\"Service Unavailable\",\"status\":503,\"detail\":\"Service unavailable\"}";

  /** The gateway timeout error example. */
  public static final String GATEWAY_TIMEOUT_ERROR =
      "{\"type\":\"about:blank\",\"title\":\"Gateway Timeout\",\"status\":504,\"detail\":\"Gateway timeout\"}";
}
