package com.switchfully.euder.infrastructure.exceptions;

public class InvalidItemAmountInStockException extends RuntimeException {
    public InvalidItemAmountInStockException(String message) {
        super(message);
    }
}
