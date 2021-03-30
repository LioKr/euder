package com.switchfully.euder.infrastructure.exceptions;

public class InvalidItemDescriptionException extends RuntimeException {
    public InvalidItemDescriptionException(String message) {
        super(message);
    }
}
