package com.bytebandits.hireharmonics.dto.response;

import com.bytebandits.hireharmonics.model.Role;

import java.util.Set;

public record LoginResponseDto(
        Set<Role> roles,
        String token
) {
}
