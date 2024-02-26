package com.react.backend.controllers;

import com.react.backend.models.User;
import com.react.backend.repository.UserRepository;
import com.react.backend.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public String signUp(@RequestBody User user) {
        // Implement signup logic, save user to the database
        authService.signUp(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user) {
        String token = authService.login(user.getUsername(), user.getPassword());
        Map<String, String> response = new HashMap<>();
        response.put("access_token", token);
        return ResponseEntity.ok(response);
    }
}
