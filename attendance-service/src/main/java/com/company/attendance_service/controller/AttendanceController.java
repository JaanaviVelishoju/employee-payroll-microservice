package com.company.attendance_service.controller;

import com.company.attendance_service.dto.AttendanceDto;
import com.company.attendance_service.entity.Attendance;
import com.company.attendance_service.service.AttendanceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    AttendanceService service;

    @PostMapping
    public ResponseEntity<Attendance> mark(@Valid @RequestBody AttendanceDto attendanceDto){

        return ResponseEntity.ok( service.mark(attendanceDto));
    }

    @GetMapping("/{empId}/monthly")
    public long monthly(@PathVariable("empId") Long empId ,
                        @RequestParam("year") int year ,
                        @RequestParam("month") int month){

        return service.monthlyPresentDays(empId,year,month);
    }
}
