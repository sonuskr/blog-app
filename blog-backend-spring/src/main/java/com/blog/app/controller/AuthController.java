package com.blog.app.controller;

import com.blog.app.model.LoginRequest;
import com.blog.app.model.LoginResponse;
import com.blog.app.model.User;
import com.blog.app.service.JwtService;
import com.blog.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = userService.getUserByUsername(loginRequest.getUsername());
        
        if (user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword()) 
            && user.get().getActive()) {
            
            String token = jwtService.generateToken(user.get().getUsername(), user.get().getRole().toString());
            LoginResponse response = new LoginResponse(token, user.get().getUsername(), user.get().getRole().toString());
            
            return ResponseEntity.ok(response);
        }
        
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    @PostMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            if (jwtService.isTokenValid(token)) {
                String username = jwtService.extractUsername(token);
                return ResponseEntity.ok("Token valid for user: " + username);
            }
        }
        return ResponseEntity.status(401).body("Invalid token");
    }
}