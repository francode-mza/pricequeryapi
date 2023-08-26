package com.francode.pricequeryapi.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {RestRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(RestRequestException exception){

        HttpStatus status = exception.getHttpStatus();
        RestException restException = new RestException.Builder()
                .message(exception.getMessage())
                .throwable(exception)
                .httpStatus(status)
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(restException, status);
    }
}

