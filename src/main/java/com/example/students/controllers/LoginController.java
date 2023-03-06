package com.example.students.controllers;

import com.example.students.models.Session;
import com.example.students.models.User;
import com.example.students.services.RoleService;
import com.example.students.services.SessionService;
import com.example.students.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalTime;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class LoginController {


    private final UserService userService;
    private final RoleService roleService;
    private final SessionService sessionService;


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



    @PostMapping(value = "/login")
    public String postLogin(@ModelAttribute User loginUser, HttpServletResponse response) {

        User user = userService.findByUsername(loginUser.getUsername());

        if (user != null) {
            if(userService.checkPassword(user,user.getPassword())) {
                System.out.println("Password was correct");
                String id = UUID.randomUUID().toString();

                //check if user already has a session
                System.out.println(user.getSession());
                if(user.getSession()!=null ) {
                    sessionService.deleteSession(user.getSession());
                }
                Session session= new Session(id,roleService.getRole(user), new java.sql.Timestamp(new java.util.Date().getTime()),user);
                System.out.println(session);
                user.setSession(session);

                if(sessionService.saveSession(session)!=null) {
                    System.out.println("creating a cookie");
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
