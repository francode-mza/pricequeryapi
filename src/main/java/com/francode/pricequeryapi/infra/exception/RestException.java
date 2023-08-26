package com.francode.pricequeryapi.infra.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class RestException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final LocalDateTime timestamp;

    public RestException(String message, Throwable throwable, HttpStatus httpStatus, LocalDateTime timestamp) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public static class Builder {
        private String message;
        private Throwable throwable;
        private HttpStatus httpStatus;
        private LocalDateTime timestamp;

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder throwable(Throwable throwable) {
            this.throwable = throwable;
            return this;
        }

        public Builder httpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public Builder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public RestException build() {
            return new RestException(message, throwable, httpStatus, timestamp);
        }
    }
}