package com.example.students.controllers;

import com.example.students.exeptions.UserDoesNotHavePermissionException;
import com.example.students.models.*;
import com.example.students.services.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/groups")
@AllArgsConstructor
public class GroupMenuController {

    private final SessionService sessionService;
    private final NavbarService navbarService;
    private final CookieService cookieService;
    private final RoleService roleService;
    private final GroupService groupService;
    private final TeacherService teacherService;

    @GetMapping
    public ModelAndView getGroupsMenuIndexPage(HttpServletRequest request) {
        if (!cookieService.isSessionPresent(request.getCookies())) {
            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());

            if (role.equals("principal")) {

                for(Teacher teacher:teacherService.findAllNotAssignedToClassBySchoolId(session.getUser().getSchool().getId())){
                    System.out.println(teacher);
                }

                return new ModelAndView("/classes-menu-index")
                        .addObject("user", new User())
                        .addObject("navElements", navbarService
                                .getNavbar(cookieService.getValue(request.getCookies()), sessionService))
                        .addObject("group", new Group());
            }
        }
        throw new UserDoesNotHavePermissionException();
    }

    @PostMapping
    public ModelAndView postGroup(@ModelAttribute Group group, HttpServletRequest request) {
        if (cookieService.isSessionPresent(request.getCookies())) {
            throw new UserDoesNotHavePermissionException();
        } else {
            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("principal")) {
                groupService.save(group);
                return new ModelAndView("redirect:/groups");
            }
            return null;
        }
    }
}
