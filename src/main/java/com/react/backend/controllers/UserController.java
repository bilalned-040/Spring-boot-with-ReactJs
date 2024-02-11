package com.react.backend.controllers;

import com.react.backend.models.User;
import com.react.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public String signUp(@RequestBody User user) {
        // Implement signup logic, save user to the database
        userRepository.save(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        // Implement login logic, validate user credentials
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid username or password";
        }
    }
}
