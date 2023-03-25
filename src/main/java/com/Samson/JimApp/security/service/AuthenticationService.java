package com.Samson.JimApp.security.service;

import com.Samson.JimApp.exception.exceptions.ApiBadRequestException;
import com.Samson.JimApp.security.dto.AuthenticationResponse;
import com.Samson.JimApp.security.dto.LoginRequest;
import com.Samson.JimApp.security.dto.RegisterRequest;
import com.Samson.JimApp.user.entity.Role;
import com.Samson.JimApp.user.entity.User;
import com.Samson.JimApp.user.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserDetailsService detailsService;

    public AuthenticationService(UserService userService,
                                 PasswordEncoder passwordEncoder,
                                 AuthenticationManager manager,
                                 JwtService jwtService,
                                 UserDetailsService detailsService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = manager;
        this.jwtService = jwtService;
        this.detailsService = detailsService;
    }

    public String register(RegisterRequest request){
        if (userService.doesUserExist(request.email()))
            throw  new ApiBadRequestException("Username is already used");
        User user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .build();
        userService.addUser(user);

        return "User has been registered";
    }

    public AuthenticationResponse login(LoginRequest request){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails user = detailsService.loadUserByUsername(request.email());

        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }
}

