package com.example.attendence_service.controller;

import com.example.attendence_service.entity.Attendance;
import com.example.attendence_service.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class AttendanceController {

    @Autowired
    AttendanceService service;

    @PostMapping("/attendance")
    public Attendance mark(@RequestBody Attendance attendance){
        return service.mark(attendance);
    }

    @GetMapping("/attendance/{empId}/monthly")
    public long monthly(@PathVariable Long empId ,
                        @RequestParam int year ,
                        @RequestParam int month){

        return service.monthlyPresentDays(empId,year,month);
    }
}
