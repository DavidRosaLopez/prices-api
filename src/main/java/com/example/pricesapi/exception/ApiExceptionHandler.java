package com.example.pricesapi.exception;

import jakarta.validation.ConstraintViolationException;
import java.util.NoSuchElementException;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/** Global exception handler that returns the API error contract. */
@RestControllerAdvice
public class ApiExceptionHandler {

  /** Handle bad request exceptions. */
  @ExceptionHandler({
    MissingServletRequestParameterException.class,
    MethodArgumentTypeMismatchException.class,
    ConstraintViolationException.class,
    IllegalArgumentException.class
  })
  public ResponseEntity<ProblemDetail> handleBadRequest() {
    ProblemDetail problemDetail = ApiError.BAD_REQUEST.toProblemDetail();
    return ResponseEntity.status(problemDetail.getStatus()).body(problemDetail);
  }

  /** Handle not found exceptions. */
  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<ProblemDetail> handleNotFound() {
    ProblemDetail problemDetail = ApiError.NOT_FOUND.toProblemDetail();
    return ResponseEntity.status(problemDetail.getStatus()).body(problemDetail);
  }

  /** Handle generic exceptions. */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ProblemDetail> handleGeneric() {
    ProblemDetail problemDetail = ApiError.INTERNAL_SERVER_ERROR.toProblemDetail();
    return ResponseEntity.status(problemDetail.getStatus()).body(problemDetail);
  }
}
