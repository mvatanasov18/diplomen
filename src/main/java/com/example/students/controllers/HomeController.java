package com.example.students.controllers;

import com.example.students.models.Address;
import com.example.students.models.Principal;
import com.example.students.models.School;
import com.example.students.models.User;
import com.example.students.repositories.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private PrincipalRepository principalRepository;

    @Autowired
    private UserJdbcTemplateRepository userJdbcTemplateRepository;
    @GetMapping(value = "/")
    public String getIndex(){
        return "index";
    }
    @GetMapping(value="/register")
    public String getRegister(Model model,HttpServletRequest request){
        model.addAttribute("user",new User());
        model.addAttribute("address",new Address());
        model.addAttribute("school",new School());
        return "register";
    }
    @GetMapping(value="/login")
    public String getLogin(Model model,HttpServletRequest request){
        model.addAttribute("user",new User());
        return "login";
    }
    @PostMapping(value="/register")
    public String postRegister(@ModelAttribute User user,@ModelAttribute Address address,@ModelAttribute School school){
        System.out.println("Tuk sum");
        Principal principal=new Principal();
        school.setAddress(address);
        user.setSchool(school);
        principal.setUser(user);
        principal.setVerified(false);

        addressRepository.save(address);
        schoolRepository.save(school);
        userRepository.save(user);
        principalRepository.save(principal);

        return "login";
    }
    @PostMapping(value="/login")
    public String postLogin(@ModelAttribute User user, HttpServletResponse response){
        User temp = userRepository.findByUsername(user.getUsername());
        System.out.println("TUkaaa");
        if(temp!=null) {
            String id = UUID.randomUUID().toString();

            user.setAuthToken(id);
            userJdbcTemplateRepository.saveSessionByUsername(user.getAuthToken(), user.getUsername());

            Cookie cookie=new Cookie("session",id);
            cookie.setMaxAge(4*60*60);
            response.addCookie(cookie);
            return "redirect:/";
        }else{
            return "error";
        }
    }
}
