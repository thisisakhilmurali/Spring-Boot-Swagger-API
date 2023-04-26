package com.example.springboottest.exceptions;

public class StudentNotFoundException extends RuntimeException{

    private static final long serialVersionOnUid = 1L;

    public StudentNotFoundException(String message) {
        super(message);
    }
}
