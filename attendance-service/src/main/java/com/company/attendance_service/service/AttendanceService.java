package com.company.attendance_service.service;

import com.company.attendance_service.entity.Attendance;
import com.company.attendance_service.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository repo;

    public Attendance mark(Attendance attendance){
        return repo.save(attendance);
    }

    public long monthlyPresentDays(Long empId,int year ,int month){

        LocalDate start =LocalDate.of(year, month, 1);

        LocalDate end =start.withDayOfMonth(start.lengthOfMonth());

        return repo.findByEmployeeIdAndDateBetween(empId,start,end)
                .stream()
                .filter(a-> a.isPresent())  //for boolean return type  or use getPresent for Boolean return
                .count();
    }
}
