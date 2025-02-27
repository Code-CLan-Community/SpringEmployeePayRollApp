package com.example.Spring_PayRoll_App.service;

import com.example.Spring_PayRoll_App.dto.EmployeeDTO;
import com.example.Spring_PayRoll_App.model.Employee;
import com.example.Spring_PayRoll_App.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;




@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    // Convert Employee to DTO
    private EmployeeDTO convertToDTO(Employee employee) {
        return new EmployeeDTO(employee.getName(), employee.getSalary());
    }

    // Fetch all employees
    public List<EmployeeDTO> getAllEmployees() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Fetch by ID
    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        return repository.findById(id).map(this::convertToDTO);
    }

    // Create new employee
    public EmployeeDTO createEmployee(EmployeeDTO dto) {
        Employee employee = new Employee(dto.getName(), dto.getSalary());
        Employee savedEmployee = repository.save(employee);
        return convertToDTO(savedEmployee);
    }

    // Update employee
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {
        return repository.findById(id).map(emp -> {
            emp.setName(dto.getName());
            emp.setSalary(dto.getSalary());
            return convertToDTO(repository.save(emp));
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // Delete employee
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}

