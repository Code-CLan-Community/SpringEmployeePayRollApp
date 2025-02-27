package com.example.Spring_PayRoll_App.repository;

import com.example.Spring_PayRoll_App.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
