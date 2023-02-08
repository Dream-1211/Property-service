package com.coderboost.propertyservice.exceptions;

import org.modelmapper.spi.ErrorMessage;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorMessage> handleException(Exception ex) {
        return new ResponseEntity<ErrorMessage>( new ErrorMessage(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<ErrorMessage>(new ErrorMessage(ex.getMessage()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorMessage> handleRunTimeException(RuntimeException ex) {
        return new ResponseEntity<ErrorMessage>(new ErrorMessage(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorMessage> handleNotFound(NotFoundException ex) {
        return new ResponseEntity<ErrorMessage>(new ErrorMessage(ex.getMessage()), HttpStatus.NOT_FOUND);
    }




}
