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
@RequestMapping(value = "/studentsMenu")
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
                return new ModelAndView("/students-menu-index")
                        .addObject("navElements", navbarService
                                .getNavbar(cookieService.getValue(request.getCookies()), sessionService))
                        .addObject("student", new Student())
                        .addObject("students", studentService.findAllBySchoolId(session.getUser().getSchool().getId()));
            }
        }
        throw new UserDoesNotHavePermissionException();
    }

    @PostMapping
    public ModelAndView postStudent(@ModelAttribute Student student, HttpServletRequest request) {
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

    @PostMapping(value = "/update")
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
    @PostMapping(value = "/delete/{id}")
    public ModelAndView deleteStudent( HttpServletRequest request, @PathVariable String id){
        if (cookieService.isSessionPresent(request.getCookies())) {

            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("principal")) {
                String schoolId= session.getUser().getSchool().getId();
                if( studentService.checkStudentByIdAndSchoolId(id,schoolId)){
                    studentService.deleteById(id);
                    return new ModelAndView("redirect:/studentsMenu");
                }
            }
        }
        throw new UserDoesNotHavePermissionException();
    }
}
