package com.example.Spring_PayRoll_App.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data  // Generates Getters, Setters, equals(), hashCode(), toString()
@NoArgsConstructor // Generates Default Constructor
@AllArgsConstructor // Generates Constructor with All Fields
public class EmployeeDTO {
    private String name;
    private double salary;
}
