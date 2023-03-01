package com.example.students.controllers;

import com.example.students.models.*;
import com.example.students.services.AddressService;
import com.example.students.services.PrincipalService;
import com.example.students.services.SchoolService;
import com.example.students.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class HomeController {



    @GetMapping(value = "/")
    public String getIndex() {
        return "index";
    }




}
