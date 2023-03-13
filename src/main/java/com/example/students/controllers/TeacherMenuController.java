package com.example.students.controllers;

import com.example.students.exeptions.UserDoesNotHavePermissionException;
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
    private final UserService userService;
    private final TeacherService teacherService;





    @GetMapping
    public ModelAndView getTeacherMenuIndexPage(HttpServletRequest request) {
        if (cookieService.isSessionPresent(request.getCookies())) {
            throw new RuntimeException();
        } else {
            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("principal")) {

                return new ModelAndView("/teachers-menu-index")
                        .addObject("navElements", navbarService
                                .getNavbar(cookieService.getValue(request.getCookies()), sessionService))
                        .addObject("teacher", new Teacher());
            }
        }
        throw new UserDoesNotHavePermissionException();
    }



    @PostMapping
    public ModelAndView postTeacher(@ModelAttribute Teacher teacher, HttpServletRequest request) {
        //todo check is the user sending the request is principal
        // - check the teacher's data
        // - save the teacher entity using the teacher service
        if (cookieService.isSessionPresent(request.getCookies())) {
            throw new RuntimeException();
        } else {
            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("principal")) {
                teacher.getUser().setSchool(session.getUser().getSchool());
                System.out.println(teacher);

                teacher.getUser().hashPassword();

                userService.save(teacher.getUser());
                teacherService.save(teacher);
                return new ModelAndView("redirect:/teachers");
            }
            throw new UserDoesNotHavePermissionException();
        }
    }
}
