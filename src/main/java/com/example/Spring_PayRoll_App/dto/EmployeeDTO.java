package com.example.Spring_PayRoll_App.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data  // Generates Getters, Setters, equals(), hashCode(), toString()
@NoArgsConstructor // Generates Default Constructor
@AllArgsConstructor // Generates Constructor with All Fields
public class EmployeeDTO {

    @NotBlank(message = "Name cannot be empty or null")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only alphabets and spaces")
    private String name;

    private double salary;
}
