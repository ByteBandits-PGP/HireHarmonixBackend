package com.bytebandits.hireharmonics.repository;

import com.bytebandits.hireharmonics.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
