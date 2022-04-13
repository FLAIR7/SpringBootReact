package com.project.demo.exception;

// Custom Exception 
public class ApiRequestException extends RuntimeException{
    public ApiRequestException(String msg) {
        super(msg);
    }

    public ApiRequestException(String msg, Throwable cause) {
        super(msg, cause);
    } 
}
