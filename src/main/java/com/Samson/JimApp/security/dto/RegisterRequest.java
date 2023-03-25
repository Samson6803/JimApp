package com.Samson.JimApp.security.dto;

public record RegisterRequest(String firstName, String lastName, String password, String email) {
}
