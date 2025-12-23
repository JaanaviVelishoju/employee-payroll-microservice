package com.company.attendance_service.service;

import com.company.attendance_service.dto.AttendanceDto;
import com.company.attendance_service.entity.Attendance;
import com.company.attendance_service.exception.AttendanceAlreadyMarkedException;

import com.company.attendance_service.exception.AttendanceNotFoundException;
import com.company.attendance_service.repository.AttendanceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service

public class AttendanceService {

    private final AttendanceRepository repo;

    public AttendanceService(AttendanceRepository repo) {
        this.repo = repo;
    }

    //    This ensures atomicity if concurrent requests hit the service.
    @Transactional
    public Attendance mark(AttendanceDto attendanceDto) {

        // Idempotent check ,✔ Concurrency safe
// First-level idempotency check
            return repo.findByEmployeeIdAndDate(attendanceDto.employeeId(), attendanceDto.date())
                    .orElseGet(() -> {

                        try {
                            Attendance att = new Attendance();
                            att.setEmployeeId(attendanceDto.employeeId());
                            att.setDate(attendanceDto.date());
                            att.setPresent(attendanceDto.present());
                            return repo.save(att);
                        } catch (DataIntegrityViolationException ex) {
                            // Second-level safety (race condition)
                            return repo.findByEmployeeIdAndDate(attendanceDto.employeeId(), attendanceDto.date())
                                    .orElseThrow(() -> new AttendanceAlreadyMarkedException("Attendance already Marked for employee"
                                            + attendanceDto.employeeId() + "on " + attendanceDto.date()));
                        }
                    } );





    }

        public long monthlyPresentDays (Long empId,int year, int month){

            LocalDate start = LocalDate.of(year, month, 1);

            LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

            long presentDays=repo.findByEmployeeIdAndDateBetween(empId, start, end)
                    .stream()
                    .filter(Attendance::isPresent)  //for boolean return type  or use getPresent for Boolean return
                    .count();

            if(presentDays==0){
                throw new AttendanceNotFoundException( "No attendance found for employee " + empId +
                        " for " + month + "/" + year);
            }

            return presentDays;
        }
    }

