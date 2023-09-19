package com.bytebandits.hireharmonics.service;

import com.bytebandits.hireharmonics.model.Role;
import com.bytebandits.hireharmonics.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getRolesByNames(List<String> roleNames) {
        return roleRepository.findAllByNameIn(roleNames);
    }
}
