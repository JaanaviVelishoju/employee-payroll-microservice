package com.company.employee_service.contoller;

import com.company.employee_service.entity.Employee;
import com.company.employee_service.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

private final EmployeeService service;

   @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }


    @PostMapping(consumes = "application/json" ,produces = "application/json")
    public ResponseEntity<Employee> create(@Valid @RequestBody Employee emp){
        System.out.println("Employee =" +emp);
        System.out.println("Employee =" +emp);

       return ResponseEntity.ok(service.create(emp));
    }

    @GetMapping("/{empId}")
    public ResponseEntity<Employee> get(@PathVariable Long empId){
        return  ResponseEntity.ok(service.getById(empId));
    }


    @GetMapping
    public Page<Employee> getAll(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "5") int size){
        Pageable pageable= PageRequest.of(page,size);
        return service.getAll(pageable);
    }

    @PostMapping("/test")
    public TestDto test(@RequestBody TestDto dto) {
        return dto;
    }


    @GetMapping("/converters")
    public Object converters(ApplicationContext context) {
        return context.getBeansOfType(
                org.springframework.http.converter.HttpMessageConverter.class
        ).keySet();
    }


}
