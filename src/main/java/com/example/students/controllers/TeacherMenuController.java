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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/teachersMenu")
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

            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("principal")) {

                return new ModelAndView("/teachers-menu-index")
                        .addObject("navElements", navbarService
                                .getNavbar(cookieService.getValue(request.getCookies()), sessionService))
                        .addObject("teacher", new Teacher())
                        .addObject("teachers",teacherService.findAllBySchoolId(session.getUser().getSchool().getId()));

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
            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("principal")) {
                teacher.getUser().setSchool(session.getUser().getSchool());
                System.out.println(teacher);

                teacher.getUser().hashPassword();

                userService.save(teacher.getUser());
                teacherService.save(teacher);
                return new ModelAndView("redirect:/teachersMenu");
            }
        }
            throw new UserDoesNotHavePermissionException();
    }

    @PostMapping(value = "/delete/{id}")
    public ModelAndView deleteGroup( HttpServletRequest request, @PathVariable String id){
        if (cookieService.isSessionPresent(request.getCookies())) {

            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("principal")) {
                String schoolId= session.getUser().getSchool().getId();
                if( teacherService.checkGroupByIdAndSchoolId(id,schoolId)){
                    teacherService.deleteById(id);
                    return new ModelAndView("redirect:/teachersMenu");
                }
            }
        }
        throw new UserDoesNotHavePermissionException();
    }
}
