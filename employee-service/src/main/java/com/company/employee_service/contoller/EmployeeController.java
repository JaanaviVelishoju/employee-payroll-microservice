package com.company.employee_service.contoller;

import com.company.employee_service.entity.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


    @PostMapping
    public Employee create(@RequestBody Employee emp){
        return emp;
    }

    @GetMapping
    public Employee get(@RequestBody Employee emp){
        return new Employee();
    }


}
