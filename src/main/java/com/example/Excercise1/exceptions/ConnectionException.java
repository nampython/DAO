package com.example.Excercise1.exceptions;

public class ConnectionException extends RuntimeException{
    public ConnectionException(String message) {
        super(message);
    }

    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
