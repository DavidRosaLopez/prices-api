package com.example.pricesapi.docs;

/** Centralized Swagger example payloads. */
public final class SwaggerExamples {

  private SwaggerExamples() {}

  public static final String BAD_REQUEST_ERROR =
      "{\"code\":\"400\",\"description\":\"Invalid request parameter\"}";
  public static final String UNAUTHORIZED_ERROR =
      "{\"code\":\"401\",\"description\":\"Unauthorized\"}";
  public static final String FORBIDDEN_ERROR =
      "{\"code\":\"403\",\"description\":\"Forbidden\"}";
  public static final String NOT_FOUND_ERROR =
      "{\"code\":\"404\",\"description\":\"Price not found\"}";
  public static final String INTERNAL_SERVER_ERROR =
      "{\"code\":\"500\",\"description\":\"Unexpected error\"}";
  public static final String SERVICE_UNAVAILABLE_ERROR =
      "{\"code\":\"503\",\"description\":\"Service unavailable\"}";
  public static final String GATEWAY_TIMEOUT_ERROR =
      "{\"code\":\"504\",\"description\":\"Gateway timeout\"}";
}
