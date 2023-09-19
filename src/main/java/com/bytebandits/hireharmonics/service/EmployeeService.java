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

    private UserService userService;
    private EmployeeRepository employeeRepository;

    private Converter converter;

    public EmployeeService(UserService userService, EmployeeRepository employeeRepository, Converter converter) {
        this.userService = userService;
        this.employeeRepository = employeeRepository;
        this.converter = converter;
    }

    public UUID createEmployee(EmployeeRequestDto dto) {
        User user = userService.createUser(dto.email(), dto.roles());
        Employee employee = converter.fromEmployeeRequestDto(dto, user);
        employeeRepository.save(employee);
        return employee.getId();
    }
}
