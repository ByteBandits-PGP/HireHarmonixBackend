package com.bytebandits.hireharmonics.repository;

import com.bytebandits.hireharmonics.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

}
