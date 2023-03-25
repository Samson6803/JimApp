package com.Samson.JimApp.exception.exceptions;

public class ApiNotFoundException extends RuntimeException{
    public ApiNotFoundException(String message){
        super(message);
    }
}
