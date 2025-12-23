package com.example.payroll_service.service;

import com.example.payroll_service.client.AttendanceClient;
import com.example.payroll_service.client.EmployeeClient;
import com.example.payroll_service.client.EmployeeDTO;
import com.example.payroll_service.entity.Payroll;
import com.example.payroll_service.repository.PayrollRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.Optional;

@Service
@Transactional
public class PayrollService {

    @Autowired
    PayrollRepository repo;

    @Autowired
    EmployeeClient employeeClient;

    @Autowired
    AttendanceClient attendanceClient;


@CircuitBreaker(name ="attendanceService" ,fallbackMethod = "attendanceFallback")
    public Payroll generate(Long empId, int year, int month) {

    // 1️⃣ Idempotent check
        return repo.findByEmployeeIdAndPayrollMonth(empId, YearMonth.of(year, month)).
                orElseGet(() -> createPayroll(empId, year, month));



    }


    private Payroll  createPayroll(Long empId, int year ,int month){

        EmployeeDTO emp = employeeClient.getEmployee(empId);

        long presentDays=attendanceClient.MonthlyPresentDays(empId, year, month);

        int totalWorkingDays=22;
        double perDaySalary=emp.salary() /totalWorkingDays;

        double payableSalary=presentDays*perDaySalary;


        Payroll payroll = new Payroll();
        payroll.setEmployeeId(empId);
        payroll.setMonthlySalary(emp.salary());
        payroll.setPayrollMonth(YearMonth.of(year,month));
        payroll.setPayableSalary(payableSalary);

        return repo.save(payroll);
    }

    // 🔁 Circuit breaker fallback
    public Payroll attendanceFallback(Long empId, int year ,int month ,Throwable ex){
        EmployeeDTO emp = employeeClient.getEmployee(empId);

        Payroll payroll = new Payroll();
        payroll.setEmployeeId(empId);
        payroll.setMonthlySalary(emp.salary());
        payroll.setPayrollMonth(YearMonth.of(year,month));
        payroll.setPayableSalary(0);

        return payroll;
    }

}







