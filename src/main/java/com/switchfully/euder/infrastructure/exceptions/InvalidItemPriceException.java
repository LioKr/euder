package com.switchfully.euder.infrastructure.exceptions;

public class InvalidItemPriceException extends RuntimeException {
    public InvalidItemPriceException(String message) {
        super(message);
    }
}
