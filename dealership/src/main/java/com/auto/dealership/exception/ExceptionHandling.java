package com.auto.dealership.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class    ExceptionHandling {
    @ExceptionHandler(HttpStatusException.class)
    public ResponseEntity<HttpResponseException> badRequestException(HttpStatusException e) {
        return createHttpResponse(e.getStatus(), e.getMessage());
    }

    private ResponseEntity<HttpResponseException> createHttpResponse(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponseException(httpStatus.value(), httpStatus,
                httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus);
    }
}
