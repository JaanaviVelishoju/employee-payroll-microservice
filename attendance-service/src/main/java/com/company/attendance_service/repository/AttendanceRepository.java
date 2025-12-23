package com.company.attendance_service.repository;

import com.company.attendance_service.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance,Long> {

    List<Attendance> findByEmployeeIdAndDateBetween(Long employeeId , LocalDate start ,LocalDate end);

    Optional<Attendance> findByEmployeeIdAndDate(Long employeeId , LocalDate start );

   boolean existsByEmployeeIdAndDate(Long employeeId,LocalDate date);
}
