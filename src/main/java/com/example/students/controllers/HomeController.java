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
    private final NavbarService navbarService;

    @GetMapping(value = "/")
    public ModelAndView getIndex(HttpServletRequest request) {
        return  new ModelAndView("index")
                .addObject("navElements",navbarService.getNavbar(request));
    }
}
