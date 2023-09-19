package com.bytebandits.hireharmonics.repository;

import com.bytebandits.hireharmonics.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

    User findByUserName(String name);
}
