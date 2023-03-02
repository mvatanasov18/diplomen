package com.example.students.controllers;

import com.example.students.models.Navbar;
import com.example.students.models.Session;
import com.example.students.services.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Array;
import java.util.*;


@Controller
public class HomeController {

    private final SessionService sessionService;
    private  final CookieService cookieService;
    private final NavbarService navbarService;
    public HomeController(SessionService sessionService,CookieService cookieService,NavbarService navbarService) {
        this.sessionService=sessionService;
        this.cookieService=cookieService;
        this.navbarService=navbarService;
    }

    @GetMapping(value = "/")
    public String getIndex(HttpServletRequest request,Model model) {

        String sessionId = cookieService.getValue(request.getCookies());
        if(sessionId.equals("")) {
            Map<String,String> temp=new HashMap<>();
            temp.put("/","Home");
            temp.put("/register","Register");
            temp.put("/login","Login");
            Navbar navbar=new Navbar(temp);
            model.addAttribute("navElements",navbar);

        }else{
            String roleName = sessionService.findById(sessionId).getRoleName();
            model.addAttribute("navElements", navbarService.getNavbarByRoleName(roleName));
        }
        return "index";
    }
}
