package com.francode.pricequeryapi.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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

    @ExceptionHandler(value = {MissingServletRequestParameterException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Object> handleMissingOrBadParameterRequest(Exception exception){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        RestException restException = new RestException.Builder()
                .message(exception.getMessage())
                .throwable(exception)
                .httpStatus(status)
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(restException,status);
    }
}

