package com.bytebandits.hireharmonics.controller;

import com.bytebandits.hireharmonics.dto.UserDTO;
import com.bytebandits.hireharmonics.model.User;
import com.bytebandits.hireharmonics.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        User user = userService.createUser(userDTO.email(), userDTO.password(), List.of("ADMIN"));

        // add check for username exists in a DB
        // add check for email exists in DB
        // create user object
        return ResponseEntity.ok("User registered successfully");
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userDTO.email(), userDTO.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok("Login successful");
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok("Logout successful");
    }

    @GetMapping("/test")
    public String testing() {
        return "Hello";
    }
}

