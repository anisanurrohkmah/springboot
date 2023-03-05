package com.projek.exception;

public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException() {
        super("data not found");
    }

    public DataNotFoundException(String message) {
        super(message);
    }
}
