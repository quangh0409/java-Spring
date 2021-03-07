package com.example.Java_Spring.exception;

public class ApiException extends Exception{
    public ApiException(String message){
        super(message);
    }
}
