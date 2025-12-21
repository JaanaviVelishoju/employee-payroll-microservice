package com.example.payroll_service.repository;

import com.example.payroll_service.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Month;
import java.time.YearMonth;

public interface PayrollRepository extends JpaRepository<Payroll,Long> {

boolean existsByEmployeeIdAndPayrollMonth(Long employeeId, YearMonth Month);

}
