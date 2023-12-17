package com.auto.dealership.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class HttpResponseException {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss")
    private final LocalDateTime timeStamp;
    private final int httpStatusCode;
    private final HttpStatus httpStatus;
    private final String reason;
    private final String message;

    public HttpResponseException(int httpStatusCode, HttpStatus httpStatus, String reason, String message) {
        this.timeStamp = LocalDateTime.now();
        this.httpStatusCode = httpStatusCode;
        this.httpStatus = httpStatus;
        this.reason = reason;
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getReason() {
        return reason;
    }

    public String getMessage() {
        return message;
    }
}
