package com.switchfully.euder.api.controllers;

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

    @ExceptionHandler
    public void handleIllegalArgumentException(IllegalArgumentException exception, HttpServletResponse response) throws IOException {
        LOGGER.warn(exception.getMessage(), exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }


}
