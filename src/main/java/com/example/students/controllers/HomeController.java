package com.example.students.controllers;

import com.example.students.models.Address;
import com.example.students.models.School;
import com.example.students.models.User;
import com.example.students.services.PrincipalService;
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


    private final PrincipalService principalService;
    private final UserService userService;

    public HomeController(PrincipalService principalService, UserService userService) {
        this.principalService = principalService;
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getIndex() {
        return "index";
    }

    @GetMapping(value = "/register")
    public String getRegister(Model model, HttpServletRequest request) {
        model.addAttribute("user", new User());
        model.addAttribute("address", new Address());
        model.addAttribute("school", new School());
        return "register";
    }

    @GetMapping(value = "/login")
    public String getLogin(Model model, HttpServletRequest request) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping(value = "/logout")
    public String postLogin( HttpServletResponse response) {
        Cookie cookie = new Cookie("session", null);
        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/";
    }

    @PostMapping(value = "/register")
    public String postRegister(@ModelAttribute User user, @ModelAttribute Address address, @ModelAttribute School school, Model model) {
        if (principalService.insertPrincipal(address, school, user)) {
            return "redirect:/login";
        }
        model.addAttribute("message", "Invalid username or password");
        return "customError";
    }

    @PostMapping(value = "/login")
    public String postLogin(@ModelAttribute User user, HttpServletResponse response) {
        User temp = userService.findByUsername(user.getUsername());
        if (temp != null) {
            if(userService.checkPassword(temp,user.getPassword())) {
                String id = UUID.randomUUID().toString();

                user.setAuthToken(id);
                if (userService.saveSessionForUser(user.getAuthToken(), user.getUsername())) {
                    Cookie cookie = new Cookie("session", id);
                    cookie.setMaxAge(4 * 60 * 60);
                    cookie.setHttpOnly(true);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    return "redirect:/";
                }
                return "customError";
            }
        }
        return "customError";
    }
}
