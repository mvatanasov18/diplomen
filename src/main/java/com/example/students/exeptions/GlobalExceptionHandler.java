package com.example.students.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailAlreadyTakenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ModelAndView handleEmailAlreadyTakenException(EmailAlreadyTakenException exception) {

        return new ModelAndView("custom-error")
                .addObject("message", "Email already taken!");
    }

    @ExceptionHandler(UsernameAlreadyTakenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ModelAndView handleUsernameAlreadyTakenException(UsernameAlreadyTakenException exception) {

        return new ModelAndView("custom-error").addObject("message", "Username already taken!");
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ModelAndView handleInvalidCredentialsException(InvalidCredentialsException exception) {

        return new ModelAndView("custom-error").addObject("message", "Invalid credentials!");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ModelAndView handleOtherExceptions(Exception exception) {
        exception.printStackTrace();
        return new ModelAndView("custom-error").addObject("message", "An error occurred!");
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ModelAndView handleNoUserFoundException(UserNotFoundException userNotFoundException) {

        return new ModelAndView("custom-error")
                .addObject("message", "No such user with this id!");
    }

    @ExceptionHandler(UserDoesNotHavePermissionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ModelAndView handleUserDoesNotHavePermissionException(UserDoesNotHavePermissionException userDoesNotHavePermissionException) {

        return new ModelAndView("custom-error")
                .addObject("message", "You don't have permission to view this page!");
    }

    @ExceptionHandler(NoAvailableTeachersException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ModelAndView handleNoAvailableTeachersException(NoAvailableTeachersException noAvailableTeachersException) {

        return new ModelAndView("custom-error")
                .addObject("message", "Add teachers before you create a class!");
    }
}
