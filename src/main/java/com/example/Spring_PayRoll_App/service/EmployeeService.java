package com.example.Spring_PayRoll_App.service;

import com.example.Spring_PayRoll_App.dto.EmployeeDTO;
import com.example.Spring_PayRoll_App.exception.EmployeeNotFoundException;
import com.example.Spring_PayRoll_App.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final List<Employee> employeeList = new ArrayList<>();
    private Long nextId = 1L;

    // ✅ Add Employee
    public Employee addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        employee.setId(nextId++);
        employeeList.add(employee);
        return employee;
    }

    // ✅ Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // ✅ Get Employee by ID (Fix: Use `orElseThrow`)
    public Employee getEmployeeById(Long id) {
        return employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found."));
    }

    // ✅ Update Employee
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = getEmployeeById(id); // Throws exception if not found
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        return employee;
    }

    // ✅ Delete Employee
    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id); // Throws exception if not found
        employeeList.remove(employee);
    }
}
