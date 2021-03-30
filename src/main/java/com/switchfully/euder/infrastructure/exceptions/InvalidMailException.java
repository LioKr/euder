package com.switchfully.euder.infrastructure.exceptions;

public class InvalidMailException extends RuntimeException {
    public InvalidMailException(String message) {
        super(message);
    }
}
