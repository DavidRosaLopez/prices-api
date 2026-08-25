package com.example.pricesapi.docs;

import lombok.experimental.UtilityClass;

/** Util class for Swagger examples. */
@UtilityClass
public final class SwaggerExamples {

  /** The bad request error example. */
  public static final String BAD_REQUEST_ERROR =
      "{\"code\":\"400\",\"description\":\"Invalid request parameters\"}";

  /** The unauthorized error example. */
  public static final String UNAUTHORIZED_ERROR =
      "{\"code\":\"401\",\"description\":\"Unauthorized\"}";

  /** The forbidden error example. */
  public static final String FORBIDDEN_ERROR = "{\"code\":\"403\",\"description\":\"Forbidden\"}";

  /** The not found error example. */
  public static final String NOT_FOUND_ERROR =
      "{\"code\":\"404\",\"description\":\"Price not found\"}";

  /** The internal server error example. */
  public static final String INTERNAL_SERVER_ERROR =
      "{\"code\":\"500\",\"description\":\"Unexpected error\"}";

  /** The service unavailable error example. */
  public static final String SERVICE_UNAVAILABLE_ERROR =
      "{\"code\":\"503\",\"description\":\"Service unavailable\"}";

  /** The gateway timeout error example. */
  public static final String GATEWAY_TIMEOUT_ERROR =
      "{\"code\":\"504\",\"description\":\"Gateway timeout\"}";
}
