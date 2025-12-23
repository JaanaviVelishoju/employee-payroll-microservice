package com.company.attendance_service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record AttendanceDto(
        @NotNull(message = "EmployeeId is required")
        Long employeeId,

        @NotNull(message = "Date is required")
        @PastOrPresent(message = "Date cannot be in future")
           LocalDate date,

         boolean present
) {
}
