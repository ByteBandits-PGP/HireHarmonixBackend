package com.bytebandits.hireharmonics.dto.response;

import com.bytebandits.hireharmonics.model.Role;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public record UserResponseDto(
        UUID id,
        String userName,
        String password,
        LocalDateTime createdDate,
        boolean activeStatus,
        Set<Role> userRoles ) {
}
