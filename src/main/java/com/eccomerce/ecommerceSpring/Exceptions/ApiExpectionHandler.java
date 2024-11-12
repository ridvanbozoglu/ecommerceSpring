package com.eccomerce.ecommerceSpring.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExpectionHandler {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ExceptionResponse> apiErrorResponce(ApiException apiException){
        ExceptionResponse response = new ExceptionResponse(apiException.getMessage(),apiException.getHttpStatus().value(), LocalDateTime.now());
        return new ResponseEntity<>(response,apiException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> apiErrorResponce(Exception exception){
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(),404,LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}