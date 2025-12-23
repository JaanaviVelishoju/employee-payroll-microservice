package com.example.payroll_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "attendance-service")
public interface AttendanceClient {

    @GetMapping("/attendance/{empId}/monthly")
    long MonthlyPresentDays(@PathVariable("empId") Long empId
            , @RequestParam("year") int year
            ,@RequestParam("month") int month);
}
