package com.bytebandits.hireharmonics.controller;

import com.bytebandits.hireharmonics.dto.request.EmployeeRequestDto;
import com.bytebandits.hireharmonics.service.EmployeeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> createEmployee( EmployeeRequestDto dto) {
        UUID employeeId = employeeService.createEmployee(dto);
        return ResponseEntity.ok("Employee created successfully with ID " + employeeId);
    }
}
