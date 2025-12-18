package com.example.payroll_service.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Payroll {

    private Long id;

    private Long employeeID;
    private Double monthlySalary;
    private String month;
}
