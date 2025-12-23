package com.example.payroll_service.controller;


import com.example.payroll_service.entity.Payroll;
import com.example.payroll_service.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.time.YearMonth;

@RestController
@RequestMapping("/payroll")
public class PayrollController {

    @Autowired
    PayrollService service;

    @PostMapping("/{empId}")
    public ResponseEntity<Payroll> generate(@PathVariable("empId") Long empId , @RequestParam("month") int month ,@RequestParam("year") int year)
    {
        return ResponseEntity.ok(service.generate(empId, year, month));
    }

}
