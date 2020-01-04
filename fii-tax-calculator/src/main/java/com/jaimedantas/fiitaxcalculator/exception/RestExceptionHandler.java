package com.jaimedantas.fiitaxcalculator.exception;

import com.jaimedantas.fiitaxcalculator.controller.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.jaimedantas.fiitaxcalculator.model.Error;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @ExceptionHandler(ArithmeticException.class)
    protected ResponseEntity<Object> handleArithmeticException(ArithmeticException ex){
        logger.error("Division by zero");
        Error response = new Error(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());

        return new ResponseEntity<>(response, response.getCode());
    }

    @ExceptionHandler(Throwable.class)
    protected ResponseEntity<Object> handleArithmeticException(Throwable ex){
        logger.error("Reached generic Exception");
        Error response = new Error(HttpStatus.INTERNAL_SERVER_ERROR, ex.getCause().getMessage());

        return new ResponseEntity<>(response, response.getCode());
    }

}
