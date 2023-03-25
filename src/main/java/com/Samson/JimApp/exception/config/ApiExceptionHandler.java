package com.Samson.JimApp.exception.config;

import com.Samson.JimApp.exception.exceptions.ApiBadRequestException;
import com.Samson.JimApp.exception.exceptions.ApiNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiNotFoundException.class})
    ResponseEntity<Object> handleApiNotFoundException(ApiNotFoundException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now()
        );
        return new ResponseEntity<Object>(apiException, badRequest);
    }

    @ExceptionHandler(value = ApiBadRequestException.class)
    ResponseEntity<Object> handleApiBadRequestException(ApiBadRequestException e){
        HttpStatus conflict = HttpStatus.CONFLICT;
        ApiException apiException = new ApiException(
                e.getMessage(),
                conflict,
                ZonedDateTime.now()
        );
        return new ResponseEntity<Object>(apiException, conflict);
    }
}
