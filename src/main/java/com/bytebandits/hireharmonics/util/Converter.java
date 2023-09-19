package com.bytebandits.hireharmonics.util;

import com.bytebandits.hireharmonics.dto.request.EmployeeRequestDto;
import com.bytebandits.hireharmonics.model.Employee;
import com.bytebandits.hireharmonics.model.User;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    public Employee fromEmployeeRequestDto(EmployeeRequestDto dto, User user) {
        return new Employee(
                dto.firstName(),
                dto.lastName(),
                dto.jobTitle(),
                dto.email(),
                dto.contactNumber(),
                user
        );
    }

}
