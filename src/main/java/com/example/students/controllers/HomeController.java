package com.example.students.controllers;

import com.example.students.models.Navbar;
import com.example.students.models.Session;
import com.example.students.services.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.util.*;


@RestController
@AllArgsConstructor
public class HomeController {

    private final SessionService sessionService;
    private  final CookieService cookieService;
    private final NavbarService navbarService;

    @GetMapping(value = "/")
    public ModelAndView getIndex(HttpServletRequest request) {

//        String sessionId = cookieService.getValue(request.getCookies());
//        if(sessionId.equals("")) {
//            Map<String,String> temp=new HashMap<>();
//            temp.put("/","Home");
//            temp.put("/register","Register");
//            temp.put("/login","Login");
//            Navbar navbar=new Navbar(temp);
//            model.addAttribute("navElements",navbar);
//
//        }else{
//            String roleName = sessionService.findById(sessionId).getRoleName();
//            model.addAttribute("navElements", navbarService.getNavbarByRoleName(roleName));
//        }
//        return "index";
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
}
