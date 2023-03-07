package com.example.students.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailAlreadyTakenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleEmailAlreadyTakenException(EmailAlreadyTakenException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Email already taken");
        errorResponse.setEx(exception);
        return errorResponse;
    }
}
