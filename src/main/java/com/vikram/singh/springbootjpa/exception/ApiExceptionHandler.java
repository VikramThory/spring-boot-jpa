package com.vikram.singh.springbootjpa.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> validationErrors = new HashMap<>();
        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();

        validationErrorList.forEach( error -> {
            String filedName = ((FieldError)error).getField();
            String validatingMsg = error.getDefaultMessage();
            validationErrors.put(filedName, validatingMsg);
        });

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        var exception = new ValidatorExceptionModel(validationErrors, badRequest, ZonedDateTime.now());
        return new ResponseEntity<>(exception, badRequest);
    }

    @ExceptionHandler(value = {InvalidParametersException.class})
    public ResponseEntity<?> handleInvalidParameterException(InvalidParametersException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        var exception = new ApiExceptionModel(e.getMessage(), badRequest, ZonedDateTime.now());
        return new ResponseEntity<>(exception, badRequest);
    }
}
