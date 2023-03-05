package com.projek.exception;

public class DataExistException extends  RuntimeException{

    public DataExistException() {
        super(" Data is already exist !");
    }

    public DataExistException(String message) {
        super(message);
    }
}
