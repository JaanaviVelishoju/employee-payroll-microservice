package com.company.employee_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name="employee")
@Data
public class Employee {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String name;

    @Email
    private String email;

    private String department;
    private Double salary;
}
