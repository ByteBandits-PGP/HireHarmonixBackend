package com.bytebandits.hireharmonics.service;

import com.bytebandits.hireharmonics.dto.request.EmployeeRequestDto;
import com.bytebandits.hireharmonics.model.Employee;
import com.bytebandits.hireharmonics.model.User;
import com.bytebandits.hireharmonics.repository.EmployeeRepository;
import com.bytebandits.hireharmonics.util.Converter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeService {

    private final UserService userService;
    private final EmployeeRepository employeeRepository;

    public EmployeeService(UserService userService, EmployeeRepository employeeRepository) {
        this.userService = userService;
        this.employeeRepository = employeeRepository;
    }

    public UUID createEmployee(EmployeeRequestDto dto) {
        User user = userService.createUser(dto.email(),"", dto.roles());
        Employee employee = Converter.fromEmployeeRequestDto(dto, user);
        employeeRepository.save(employee);
        return employee.getId();
    }
}
