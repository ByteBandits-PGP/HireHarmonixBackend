package com.bytebandits.hireharmonics.controller;

import com.bytebandits.hireharmonics.model.Role;
import com.bytebandits.hireharmonics.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllRoleNames() {
        List<Role> allRoles = roleService.getAllRoles();
        List<String> allRoleNames = new ArrayList<>();
        for(Role role: allRoles) {
            allRoleNames.add(role.getName());
        }
        return ResponseEntity.ok(allRoleNames);
    }
}
