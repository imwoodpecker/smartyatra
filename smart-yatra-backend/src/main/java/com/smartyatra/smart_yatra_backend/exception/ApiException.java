package com.smartyatra.smart_yatra_backend.exception;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
    public ApiException(String message,Throwable cause){
        super(message,cause);
    }
}