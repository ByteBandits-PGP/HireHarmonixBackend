package com.bytebandits.hireharmonics.util;

import com.bytebandits.hireharmonics.dto.request.EmployeeRequestDto;
import com.bytebandits.hireharmonics.dto.response.UserResponseDto;
import com.bytebandits.hireharmonics.model.Employee;
import com.bytebandits.hireharmonics.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

public class Converter {

    private Converter() {
    }

    public static Employee fromEmployeeRequestDto(EmployeeRequestDto dto, User user) {
        return new Employee(
                dto.firstName(),
                dto.lastName(),
                dto.jobTitle(),
                dto.email(),
                dto.contactNumber(),
                user
        );
    }

    public static UserResponseDto toUserResponseDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                user.getCreatedDate(),
                user.isActiveStatus(),
                user.getRoles()
        );
    }

    public static List<UserResponseDto> toUserResponseDtoList(List<User> users) {
        List<UserResponseDto> userResponseDtoList = users.stream().map(user -> toUserResponseDto(user)).toList();
        return userResponseDtoList;
    }

}
