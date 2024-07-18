package com.example.learninNav.exception;

import java.io.IOException;

public class SubjectNotEnrolledException extends IOException {
    
    public SubjectNotEnrolledException() {

    } 

    public SubjectNotEnrolledException(String message) {
        super(message);
    }
    
}