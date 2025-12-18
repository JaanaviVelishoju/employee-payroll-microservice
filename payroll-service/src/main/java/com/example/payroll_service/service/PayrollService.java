package com.example.payroll_service.service;

import com.example.payroll_service.client.EmployeeClient;
import com.example.payroll_service.client.EmployeeDTO;
import com.example.payroll_service.entity.Payroll;
import com.example.payroll_service.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayrollService {

    @Autowired
    PayrollRepository repo;

    @Autowired
    EmployeeClient employeeClient;

    public Payroll generate(Long empId ,String month){
       EmployeeDTO emp = employeeClient.getEmployee(empId);

       Payroll payroll=new Payroll();
       payroll.setEmployeeID(empId);
       payroll.setMonthlySalary(emp.salary());
       payroll.setMonth(month);
       return repo.save(payroll);
    }
}
