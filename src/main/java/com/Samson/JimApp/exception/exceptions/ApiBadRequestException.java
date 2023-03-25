package com.Samson.JimApp.exception.exceptions;

public class ApiBadRequestException extends RuntimeException{
    public ApiBadRequestException(String message){
        super(message);
    }
}
