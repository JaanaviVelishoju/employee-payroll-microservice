package com.company.employee_service.service;

import com.company.employee_service.entity.Employee;
import com.company.employee_service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
   private EmployeeRepository employeeRepository;

    public Employee create(Employee emp){
        return employeeRepository.save(emp);
    }

    public Employee getById(Long id){
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Page<Employee> getAll(Pageable pageable){
        return employeeRepository.findAll(pageable);
    }
}
