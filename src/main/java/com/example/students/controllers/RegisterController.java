package com.example.students.controllers;

import com.example.students.exeptions.InvalidCredentialsException;
import com.example.students.exeptions.UsernameOrEmailTakenException;
import com.example.students.models.Address;
import com.example.students.models.Principal;
import com.example.students.models.School;
import com.example.students.models.User;
import com.example.students.services.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/register")
public class RegisterController {

    private final PrincipalService principalService;
    private final UserService userService;
    private final AddressService addressService;
    private final SchoolService schoolService;
    private final NavbarService navbarService;
    private final CookieService cookieService;
    private final SessionService sessionService;


    @GetMapping
    public ModelAndView getRegister(HttpServletRequest request) {
        if (cookieService.isSessionPresent(request.getCookies())) {
            throw new RuntimeException();
        } else {
            return new ModelAndView("register").addObject("user", new User()).addObject("address", new Address()).addObject("school", new School()).addObject("navElements", navbarService.getNavbar(cookieService.getValue(request.getCookies()), sessionService));

        }
    }

    @PostMapping
    @Transactional(rollbackFor = InvalidCredentialsException.class)
    public String postRegister(@ModelAttribute User user, @ModelAttribute Address address, @ModelAttribute School school, HttpServletRequest request) {
        if (cookieService.isSessionPresent(request.getCookies())) {
            throw new RuntimeException();
        } else {
            try {

                user.hashPassword();
                school.setAddress(address);
                user.setSchool(school);
                Principal principal = new Principal();
                principal.setUser(user);

                addressService.save(address);
                schoolService.save(school);
                if (userService.save(user) == null) {
                    throw new UsernameOrEmailTakenException();
                }
                principalService.save(principal);
                System.out.println(user);
                return "redirect:/login";

            } catch (Exception e) {
                userService.delete(user);
                schoolService.delete(school);
                addressService.delete(address);
                e.printStackTrace();

            }
            return "/index";
        }
    }
}
