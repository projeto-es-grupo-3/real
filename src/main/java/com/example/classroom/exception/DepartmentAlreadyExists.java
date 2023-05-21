package com.example.classroom.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

// Exception class who detect if a department already exists
@ResponseStatus(HttpStatus.CONFLICT)
public class DepartmentAlreadyExists extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    public DepartmentAlreadyExists(String message) {
        super(message);
    }
}
