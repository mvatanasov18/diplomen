package com.example.students.controllers;

import com.example.students.models.Address;
import com.example.students.models.Principal;
import com.example.students.models.School;
import com.example.students.models.User;
import com.example.students.services.AddressService;
import com.example.students.services.PrincipalService;
import com.example.students.services.SchoolService;
import com.example.students.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final PrincipalService principalService;
    private final UserService userService;
    private final AddressService addressService;
    private final SchoolService schoolService;

    public RegisterController(PrincipalService principalService, UserService userService,
                          AddressService addressService,SchoolService schoolService) {
        this.principalService = principalService;
        this.userService = userService;
        this.addressService=addressService;
        this.schoolService=schoolService;
    }

    @GetMapping(value = "/register")
    public String getRegister(Model model, HttpServletRequest request) {
        model.addAttribute("user", new User());
        model.addAttribute("address", new Address());
        model.addAttribute("school", new School());
        return "register";
    }

    @PostMapping(value = "/register")
    public String postRegister(@ModelAttribute User user, @ModelAttribute Address address, @ModelAttribute School school, Model model) {

        //check if data is valid




        school.setAddress(address);
        user.setSchool(school);
        Principal principal = new Principal();
        principal.setUser(user);

        addressService.saveAddress(address);
        schoolService.saveSchool(school);
        userService.saveUser(user);

        if (principalService.insertPrincipal(principal)) {
            return "redirect:/login";
        }
        model.addAttribute("message", "Invalid username or password");
        return "customError";
    }
}
