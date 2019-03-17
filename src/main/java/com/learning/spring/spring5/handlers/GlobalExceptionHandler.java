package com.learning.spring.spring5.handlers;

import com.learning.spring.spring5.exception.BadPathParamException;
import com.learning.spring.spring5.model.ErrorResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    @ExceptionHandler(BadPathParamException.class)
    public ResponseEntity<ErrorResponse> handleBadInputException(BadPathParamException ex) {
        log.error("Error occurred: ", ex);
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "Invalid Input", "Path Parameter");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
