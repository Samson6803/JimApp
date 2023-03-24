package com.Samson.JimApp.exception;

public class ApiBadRequestException extends RuntimeException{
    public ApiBadRequestException(String message){
        super(message);
    }
}
