package com.bytebandits.hireharmonics.controller;

import com.bytebandits.hireharmonics.dto.UserDTO;
import com.bytebandits.hireharmonics.dto.response.LoginResponseDto;
import com.bytebandits.hireharmonics.dto.response.UserResponseDto;
import com.bytebandits.hireharmonics.model.Role;
import com.bytebandits.hireharmonics.model.User;
import com.bytebandits.hireharmonics.service.UserService;
import com.bytebandits.hireharmonics.util.Converter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;

    private SecurityContextRepository securityContextRepository =
            new HttpSessionSecurityContextRepository();

    private final SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder.getContextHolderStrategy();


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
    public ResponseEntity<LoginResponseDto> login(@RequestBody UserDTO userDTO, HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userDTO.email(), userDTO.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        SecurityContext context =  securityContextHolderStrategy.createEmptyContext();
        context.setAuthentication(authentication);
        securityContextHolderStrategy.setContext(context);
        securityContextRepository.saveContext(context, request, response);

        String jsessionId = null;

        if (response.getHeader("Set-Cookie") != null) {
            jsessionId = response.getHeader("Set-Cookie").split(";")[0].split("=")[1];
        }

        Set<Role> roleName = userService.findUserRole(userDTO.email());

        return ResponseEntity.ok(new LoginResponseDto(roleName, jsessionId));
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok("Logout successful");
    }

    @GetMapping("/test")
    public String testing() {
        return "Hello";
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        List<UserResponseDto> userResponseDtos = Converter.toUserResponseDtoList(allUsers);
        return ResponseEntity.ok(userResponseDtos);
    }

}

