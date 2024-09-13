package com.jwtexample.jwtdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwtexample.jwtdemo.model.User;
import com.jwtexample.jwtdemo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email).get();
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
}
