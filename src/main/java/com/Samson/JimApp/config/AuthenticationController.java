package com.Samson.JimApp.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service){
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(service.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }

}