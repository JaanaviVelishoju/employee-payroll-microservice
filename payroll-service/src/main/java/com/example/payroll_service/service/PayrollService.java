package com.example.payroll_service.service;

import com.example.payroll_service.client.EmployeeClient;
import com.example.payroll_service.client.EmployeeDTO;
import com.example.payroll_service.entity.Payroll;
import com.example.payroll_service.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;

@Service
public class PayrollService {

    @Autowired
    PayrollRepository repo;

    @Autowired
    EmployeeClient employeeClient;

    public Payroll generate(Long id , YearMonth month){

        if(repo.existsByEmployeeIdAndPayrollMonth(id,month)){
            throw new RuntimeException("Payroll already generated fro employee "+id +" for month " +month);
        }
       EmployeeDTO emp = employeeClient.getEmployee(id);

       Payroll payroll=new Payroll();
       payroll.setEmployeeId(id);
       payroll.setMonthlySalary(emp.salary());
       payroll.setPayrollMonth(month);
       return repo.save(payroll);
    }
}
