package com.example.students.controllers;

import com.example.students.models.User;
import com.example.students.services.CookieService;
import com.example.students.services.NavbarService;
import com.example.students.services.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/students")
@AllArgsConstructor
public class StudentMenuController {

    private final SessionService sessionService;
    private final NavbarService navbarService;
    private final CookieService cookieService;

@GetMapping
    public ModelAndView getStudentsMenuIndexPage(HttpServletRequest request){
        if(!cookieService.isSessionPresent(request.getCookies())){
            return new ModelAndView("/students-menu-index")
                    .addObject("user",new User())
                    .addObject("navElements",navbarService.getNavbar(cookieService.getValue(request.getCookies()),sessionService));
        }
        throw new RuntimeException();
    }
}
