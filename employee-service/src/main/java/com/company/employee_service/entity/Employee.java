package com.company.employee_service.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Employee {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String email;
    private String department;
    private Double salary;
}
