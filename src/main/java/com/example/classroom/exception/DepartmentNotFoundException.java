package com.example.classroom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepartmentNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;
    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
