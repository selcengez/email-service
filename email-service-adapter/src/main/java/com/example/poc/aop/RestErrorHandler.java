package com.example.poc.aop;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.poc.dto.RestErrorMessage;
import com.example.poc.exception.BaseException;

@Component
@RestControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestErrorMessage handleValidationException(ConstraintViolationException ex){
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        String message= violations.stream().map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("|"));
        return new RestErrorMessage(message,message,"95b49f5c-5b2e-43de-8967-fed414a96dc0");
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestErrorMessage handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        String message= ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining("|"));
        return new RestErrorMessage(message,message,"0d3a5eed-ee48-4d23-985e-99d2ac3afacb");
    }

    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public RestErrorMessage handleBaseExceptions(BaseException e) {
        return new RestErrorMessage(e.getMessage(), e.getI18nId(), e.getDebugId());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public RestErrorMessage handleRuntimeExceptions(RuntimeException e) {
        return new RestErrorMessage(e.getMessage(), e.getClass().getSimpleName(), "349159c0-50a4-4e00-ba5b-669977e99907");
    }

}
