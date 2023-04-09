package com.example.students.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UsernameOrEmailTakenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ModelAndView handleEmailAlreadyTakenException(UsernameOrEmailTakenException exception) {

        return new ModelAndView("custom-error")
                .addObject("message", "Имейлът или потребителското име вече са заети");
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ModelAndView handleInvalidCredentialsException(InvalidCredentialsException exception) {

        return new ModelAndView("custom-error").addObject("message", "Грешни данни за вписване!");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ModelAndView handleOtherExceptions(Exception exception) {
        exception.printStackTrace();
        return new ModelAndView("custom-error").addObject("message", "Грешка! Моля затворете страницата и опитайте отново! Ако грешката продължава моля посетете: https://github.com/codingburgas/2223-dzi-java-mvatanasov18");
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ModelAndView handleNoUserFoundException(UserNotFoundException userNotFoundException) {

        return new ModelAndView("custom-error")
                .addObject("message", "Няма потребител с такъв идентификационен номер!");
    }

    @ExceptionHandler(UserDoesNotHavePermissionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ModelAndView handleUserDoesNotHavePermissionException(UserDoesNotHavePermissionException userDoesNotHavePermissionException) {

        return new ModelAndView("custom-error")
                .addObject("message", "Не сте оторизирани да посещавате тази страница! Моля впишете се и пробвайте пак?");
    }

    @ExceptionHandler(NoAvailableTeachersException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ModelAndView handleNoAvailableTeachersException(NoAvailableTeachersException noAvailableTeachersException) {

        return new ModelAndView("custom-error")
                .addObject("message", "Добавете учители преди да създавате класове!");
    }
}
