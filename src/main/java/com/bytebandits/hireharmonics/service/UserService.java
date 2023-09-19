package com.bytebandits.hireharmonics.service;

import com.bytebandits.hireharmonics.model.Role;
import com.bytebandits.hireharmonics.model.User;
import com.bytebandits.hireharmonics.model.UserRole;
import com.bytebandits.hireharmonics.repository.UserRepository;
import com.bytebandits.hireharmonics.repository.UserRoleRepository;
import com.bytebandits.hireharmonics.util.RandomPasswordGenerator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    private UserRepository userRepository;
    private RoleService roleService;
    private UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleService roleService, UserRoleRepository userRoleRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(String email, List<String> roleNames) {
        String password = passwordEncoder.encode(generateRandomPassword());

        User user = new User(email, password);
        userRepository.save(user);
        createUserRoleEntities(user, roleNames);
        return user;
    }

    private void createUserRoleEntities(User user, List<String> roleNames) {
        List<Role> roles = roleService.getRolesByNames(roleNames);
        List<UserRole> userRoles = new ArrayList<>();
        for(Role role: roles) {
            UserRole userRole = new UserRole(user, role, LocalDateTime.now());
            userRoles.add(userRole);
        }
        userRoleRepository.saveAll(userRoles);
    }

    private String generateRandomPassword() {
        return RandomPasswordGenerator.generateRandomPassword();
    }

    public Boolean validatePassword() {
        return false;
    }

}
