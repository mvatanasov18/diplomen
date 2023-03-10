package com.example.students.controllers;

import com.example.students.exeptions.UserDoesNotHavePermissionException;
import com.example.students.models.Session;
import com.example.students.models.Student;
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
@RequestMapping(value = "/students")
@AllArgsConstructor
public class StudentMenuController {

    private final SessionService sessionService;
    private final NavbarService navbarService;
    private final CookieService cookieService;
    private final RoleService roleService;
    private final StudentService studentService;

    @GetMapping
    public ModelAndView getTeacherMenuIndexPage(HttpServletRequest request) {
        if (cookieService.isSessionPresent(request.getCookies())) {
            throw new RuntimeException();
        }
        else {
            Session session= sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if(role.equals("principal")) {
                Student student = new Student();
                student.getUser().setSchool(session.getUser().getSchool());
                System.out.println(student);
                return new ModelAndView("/teacher-menu-index")
                        .addObject("user", new User())
                        .addObject("navElements", navbarService.getNavbar(cookieService.getValue(request.getCookies()), sessionService))
                        .addObject("student", student);
            }
        }
        throw new UserDoesNotHavePermissionException();
    }

    @PostMapping
    public ModelAndView postTeacher(@ModelAttribute Student student, HttpServletRequest request) {
        //todo check is the user sending the request is principal
        // - check the teacher's data
        // - save the teacher entity using the teacher service
        if (cookieService.isSessionPresent(request.getCookies())) {
            throw new RuntimeException();
        } else {
            String role = roleService.getRoleFromSessionId(cookieService.getValue(request.getCookies()));
            if (role.equals("principal")) {
                studentService.save(student);
            }
            throw new UserDoesNotHavePermissionException();
        }
    }
}
