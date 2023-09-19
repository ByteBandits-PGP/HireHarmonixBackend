package com.bytebandits.hireharmonics.repository;

import com.bytebandits.hireharmonics.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
}
