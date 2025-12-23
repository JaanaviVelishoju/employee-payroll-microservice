package com.company.attendance_service.exception;

public class AttendanceAlreadyMarkedException extends RuntimeException{


    public AttendanceAlreadyMarkedException(String message){
        super(message);
    }
}
