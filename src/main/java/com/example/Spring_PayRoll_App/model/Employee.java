package com.example.Spring_PayRoll_App.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees") // Explicitly defining table name
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Ensures name cannot be null in the DB
    private String name;

    private Double salary;

    // Constructors
    public Employee() {}

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
}
