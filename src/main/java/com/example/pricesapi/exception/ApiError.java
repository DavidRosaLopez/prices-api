package com.example.pricesapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

/** Standard API error codes and messages. */
public enum ApiError {
  BAD_REQUEST(HttpStatus.BAD_REQUEST, "Invalid request parameters"),
  NOT_FOUND(HttpStatus.NOT_FOUND, "Not found"),
  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");

  private final HttpStatus status;
  private final String detail;

  ApiError(HttpStatus status, String detail) {
    this.status = status;
    this.detail = detail;
  }

  public ProblemDetail toProblemDetail() {
    return ProblemDetail.forStatusAndDetail(status, detail);
  }
}
