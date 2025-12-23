package com.example.payroll_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.YearMonth;


@Entity
@Table(name="payroll" , uniqueConstraints = {@UniqueConstraint(columnNames = {"employeeId","payrollMonth"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="employee_id" ,nullable= false)
    private Long employeeId;

    @Column(nullable = false)
    private Double monthlySalary;

    private double payableSalary;

    @Column(name="payroll_month", nullable = false )
    private YearMonth payrollMonth;
}
