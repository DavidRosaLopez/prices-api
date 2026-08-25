package com.example.pricesapi.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/** Global exception handler that returns the API error contract. */
@Slf4j
@RestControllerAdvice(basePackages = "com.example.pricesapi.controller")
public class ApiExceptionHandler {

  /** Handle bad request exceptions. */
  @ExceptionHandler({
    MissingServletRequestParameterException.class,
    MethodArgumentTypeMismatchException.class,
    ConstraintViolationException.class,
    IllegalArgumentException.class
  })
  public ResponseEntity<ProblemDetail> handleBadRequest() {
    return toResponse(HttpStatus.BAD_REQUEST, "Invalid request parameters");
  }

  /** Handle generic exceptions. */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ProblemDetail> handleGeneric(Exception ex) {
    log.error("Unhandled exception", ex);
    return toResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
  }

  /** Convert an API error to a response entity. */
  private ResponseEntity<ProblemDetail> toResponse(HttpStatus status, String detail) {
    return ResponseEntity.status(status).body(ProblemDetail.forStatusAndDetail(status, detail));
  }
}
