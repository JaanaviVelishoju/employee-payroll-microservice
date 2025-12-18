package com.example.payroll_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "employee-service" ,url ="http://localhost:8080")
public interface EmployeeClient {

    @GetMapping("/employees/{id}")
    EmployeeDTO getEmployee(@PathVariable Long id);
}
