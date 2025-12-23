package com.company.employee_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@NotBlank(message = "Name is required")
@Column(nullable = false)
    private String name;

    @NotBlank(message = "Email is required")
@Email(message = "Email is required")
    @Column(unique = true)
    private String email;

@NotBlank(message = "Department is required")
@Column(nullable = false)
    private String department;

    @NotNull(message = "Salary is required")
    @Column(nullable = false)
    private Double salary;
}
