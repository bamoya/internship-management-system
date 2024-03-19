package com.ecm.internManagementApp.exception;

public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException(String message){
        super(message);
    }
}
