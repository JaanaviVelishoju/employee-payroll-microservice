package com.example.payroll_service.controller;


import com.example.payroll_service.entity.Payroll;
import com.example.payroll_service.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayrollController {

    @Autowired
    PayrollService service;

    @PostMapping("/payroll/{empid}")
    public Payroll generate(@PathVariable Long empId , @RequestParam String month)
    {
        return service.generate(empId,month);
    }

}
