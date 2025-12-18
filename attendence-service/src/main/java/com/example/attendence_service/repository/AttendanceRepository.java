package com.example.attendence_service.repository;

import com.example.attendence_service.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance,Long> {

    List<Attendance> findByEmployeeIdAndDateBetween(Long employeeId , LocalDate start ,LocalDate end);
}
