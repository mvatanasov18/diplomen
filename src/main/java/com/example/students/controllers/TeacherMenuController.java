package com.example.students.controllers;

import com.example.students.models.Session;
import com.example.students.models.Student;
import com.example.students.models.Teacher;
import com.example.students.models.User;
import com.example.students.services.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/teachers")
@AllArgsConstructor
public class TeacherMenuController {

    private final SessionService sessionService;
    private final NavbarService navbarService;
    private final CookieService cookieService;
    private final RoleService roleService;
    private final TeacherService teacherService;

    @GetMapping
    public ModelAndView getStudentsMenuIndexPage(HttpServletRequest request) {
        if (!cookieService.isSessionPresent(request.getCookies())) {
            Session session= sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if(role.equals("principal")) {
                Teacher teacher = new Teacher();
                teacher.getUser().setSchool(session.getUser().getSchool());
                System.out.println(teacher);
                return new ModelAndView("/students-menu-index")
                        .addObject("user", new User())
                        .addObject("navElements", navbarService.getNavbar(cookieService.getValue(request.getCookies()), sessionService))
                        .addObject("teacher", teacher);
            }
        }
        throw new RuntimeException();
    }

    @PostMapping
    public ModelAndView postStudent(@ModelAttribute Teacher teacher, HttpServletRequest request) {
        //todo check is the user sending the request is principal
        // - check the student's data
        // - save the student entity using the student service
        if (cookieService.isSessionPresent(request.getCookies())) {
            throw new RuntimeException();
        } else {
            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("principal")) {


                teacherService.save(teacher);
            }
            return null;
        }
    }
}
