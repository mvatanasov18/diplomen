package com.example.students.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailAlreadyTakenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ModelAndView handleEmailAlreadyTakenException(EmailAlreadyTakenException exception) {

        return new ModelAndView("custom-error")
                .addObject("message","Email already taken!");
    }

    @ExceptionHandler(UsernameAlreadyTakenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ModelAndView handleUsernameAlreadyTakenException(UsernameAlreadyTakenException exception) {

        return new ModelAndView("custom-error").addObject("message","Username already taken!");
    }
    @ExceptionHandler(InvalidCredentialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ModelAndView handleInvalidCredentialsException(InvalidCredentialsException exception) {

        return new ModelAndView("custom-error").addObject("message","Invalid credentials!");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ModelAndView handleOtherExceptions(Exception exception) {

        return new ModelAndView("custom-error").addObject("message","An error occurred!");
    }
}
