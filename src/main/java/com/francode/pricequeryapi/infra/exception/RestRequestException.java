package com.francode.pricequeryapi.infra.exception;

import org.springframework.http.HttpStatus;

public class RestRequestException extends RuntimeException{

    private final HttpStatus httpStatus;

    public RestRequestException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
