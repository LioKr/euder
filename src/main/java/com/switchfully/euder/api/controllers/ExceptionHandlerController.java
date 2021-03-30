package com.switchfully.euder.api.controllers;

import com.switchfully.euder.infrastructure.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public void handleIllegalArgumentException(IllegalArgumentException exception, HttpServletResponse response) throws IOException {
        LOGGER.warn(exception.getMessage(), exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }

    //mail exceptions
    @ExceptionHandler(InvalidMailException.class)
    public void handleInvalidMailException(InvalidMailException exception, HttpServletResponse response) throws IOException {
        LOGGER.warn(exception.getMessage(), exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(InvalidItemNameException.class)
    public void handleInvalidItemNameException(InvalidItemNameException exception, HttpServletResponse response) throws IOException {
        LOGGER.warn(exception.getMessage(), exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(InvalidItemDescriptionException.class)
    public void handleInvalidItemDescriptionException(InvalidItemDescriptionException exception, HttpServletResponse response) throws IOException {
        LOGGER.warn(exception.getMessage(), exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(InvalidItemPriceException.class)
    public void handleInvalidItemPriceException(InvalidItemPriceException exception, HttpServletResponse response) throws IOException {
        LOGGER.warn(exception.getMessage(), exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(InvalidItemAmountInStockException.class)
    public void handleInvalidItemAmountInStockException(InvalidItemAmountInStockException exception, HttpServletResponse response) throws IOException {
        LOGGER.warn(exception.getMessage(), exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }

}
