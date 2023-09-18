package com.bytebandits.hireharmonics.service;

import com.bytebandits.hireharmonics.dto.UserDTO;
import com.bytebandits.hireharmonics.model.User;
import com.bytebandits.hireharmonics.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(UserDTO userDTO) {
        String password = passwordEncoder.encode(userDTO.password());
       return userRepository.save(new User(userDTO.email(),password));
    }
}
