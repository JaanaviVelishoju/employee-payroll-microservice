package com.company.employee_service.contoller;

import com.company.employee_service.entity.Employee;
import com.company.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

@Autowired
    EmployeeService service;

    @PostMapping
    public Employee create(@RequestBody Employee emp){
        return emp;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
public ResponseEntity<Page<Employee>> getAll(@RequestParam(defaultValue = "0") int page ,@RequestParam(defaultValue = "5") int size){
   Pageable pageable =PageRequest.of(page,size);
        return ResponseEntity.ok(service.getAll(pageable));
}
}
