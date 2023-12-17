package com.auto.dealership.exception;

import org.springframework.http.HttpStatus;

public class HttpStatusException extends RuntimeException {
    private HttpStatus status;

    public HttpStatusException(String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
    }

    public HttpStatusException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
