package com.example.Spring_PayRoll_App.service;

import com.example.Spring_PayRoll_App.dto.EmployeeDTO;
import com.example.Spring_PayRoll_App.model.Employee;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final List<Employee> employeeList = new ArrayList<>();
    private Long nextId = 1L;

    // Add Employee
    public Employee addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        employee.setId(nextId++);
        employeeList.add(employee);
        return employee;
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // Get Employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeList.stream().filter(emp -> emp.getId().equals(id)).findFirst();
    }

    // Update Employee
    public Optional<Employee> updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Optional<Employee> employeeOptional = getEmployeeById(id);
        employeeOptional.ifPresent(employee -> {
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());
        });
        return employeeOptional;
    }

    // Delete Employee
    public boolean deleteEmployee(Long id) {
        return employeeList.removeIf(employee -> employee.getId().equals(id));
    }
}
