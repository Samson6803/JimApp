package com.Samson.JimApp.config;

import com.Samson.JimApp.exception.ApiBadRequestException;
import com.Samson.JimApp.user.entity.Role;
import com.Samson.JimApp.user.entity.User;
import com.Samson.JimApp.user.repository.UserRepository;
import io.jsonwebtoken.Jwt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserDetailsService detailsService;

    public AuthenticationService(UserRepository repository,
                                 PasswordEncoder passwordEncoder,
                                 AuthenticationManager manager,
                                 JwtService jwtService,
                                 UserDetailsService detailsService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = manager;
        this.jwtService = jwtService;
        this.detailsService = detailsService;
    }

    public String register(RegisterRequest request){
        if (repository.existsUserByEmail(request.email()))
            throw  new ApiBadRequestException("Username is already used");
        User user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .build();
        repository.save(user);

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

record AuthenticationResponse(String jwtToken){}
record RegisterRequest(String firstName, String lastName, String password, String email) {}
record LoginRequest(String email, String password){}
