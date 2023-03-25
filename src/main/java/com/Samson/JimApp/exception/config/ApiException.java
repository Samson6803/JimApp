package com.Samson.JimApp.exception.config;

import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;

public record ApiException(String message, HttpStatus httpStatus, ZonedDateTime timeStamp) {
}
