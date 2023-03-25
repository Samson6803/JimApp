package com.Samson.JimApp.user.service;

import com.Samson.JimApp.exception.exceptions.ApiNotFoundException;
import com.Samson.JimApp.user.entity.User;
import com.Samson.JimApp.user.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public User getUser(Long userId){
        return repository.findById(userId).orElseThrow(() -> new ApiNotFoundException("No user found with id: " + userId));
    }

    public void addUser(User user){
        repository.save(user);
    }

    public boolean doesUserExist(String email){
        return repository.existsUserByEmail(email);
    }


}
