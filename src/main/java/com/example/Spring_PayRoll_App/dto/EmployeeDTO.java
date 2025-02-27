package com.example.Spring_PayRoll_App.dto;


public class EmployeeDTO {
    private String name;
    private Double salary;

    // Constructors
    public EmployeeDTO() {}

    public EmployeeDTO(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
}
