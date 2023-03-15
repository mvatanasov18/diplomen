package com.example.students.controllers;

import com.example.students.exeptions.UserDoesNotHavePermissionException;
import com.example.students.models.Session;
import com.example.students.models.Student;
import com.example.students.models.User;
import com.example.students.services.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    private final UserService userService;
    private final GroupService groupService;

    @GetMapping
    public ModelAndView getStudentsMenuIndexPage(HttpServletRequest request) {
        if (cookieService.isSessionPresent(request.getCookies())) {
            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("principal")) {
                Student student = new Student();
                student.getUser().setSchool(session.getUser().getSchool());
                System.out.println(student);
                return new ModelAndView("/students-menu-index")
                        .addObject("user", new User())
                        .addObject("navElements", navbarService
                                .getNavbar(cookieService.getValue(request.getCookies()), sessionService))
                        .addObject("student", student);
            }
        }
        throw new UserDoesNotHavePermissionException();
    }

    @PostMapping
    public ModelAndView postStudent(@ModelAttribute Student student, HttpServletRequest request) {
        //todo check is the user sending the request is principal
        // - check the student's data
        // - save the student entity using the student service
        if (cookieService.isSessionPresent(request.getCookies())) {

            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("principal")) {
                student.getUser().hashPassword();
                userService.save(student.getUser());
                studentService.save(student);
                return new ModelAndView("redirect:/students");
            }
        }
            throw new UserDoesNotHavePermissionException();
    }

    @PutMapping
    public ModelAndView putStudent(@ModelAttribute Student student, HttpServletRequest request) {
        if (cookieService.isSessionPresent(request.getCookies())) {

            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("principal")) {
                userService.save(student.getUser());
                studentService.save(student);
                return new ModelAndView("redirect:/students");
            }
        }
            throw new UserDoesNotHavePermissionException();
    }
    @DeleteMapping
    public ModelAndView deleteStudent(@ModelAttribute Student student, HttpServletRequest request) {
        if (cookieService.isSessionPresent(request.getCookies())) {

            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("principal")) {
                studentService.delete(student);
                userService.delete(student.getUser());
                return new ModelAndView("redirect:/students");
            }
        }
            throw new UserDoesNotHavePermissionException();
    }
}
