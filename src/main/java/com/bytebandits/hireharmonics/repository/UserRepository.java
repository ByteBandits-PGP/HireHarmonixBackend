package com.bytebandits.hireharmonics.repository;

import com.bytebandits.hireharmonics.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUserName(String name);
}
