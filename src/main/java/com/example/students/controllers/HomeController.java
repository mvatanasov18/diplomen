package com.example.students.controllers;

import com.example.students.services.CookieService;
import com.example.students.services.NavbarService;
import com.example.students.services.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@AllArgsConstructor
public class HomeController {
    private final NavbarService navbarService;
    private final CookieService cookieService;
    private final SessionService sessionService;

    @GetMapping(value = "/")
    public ModelAndView getIndex(HttpServletRequest request) {
        return new ModelAndView("index")
                .addObject("navElements", navbarService
                        .getNavbar(cookieService.getValue(request.getCookies()), sessionService));
    }
}
