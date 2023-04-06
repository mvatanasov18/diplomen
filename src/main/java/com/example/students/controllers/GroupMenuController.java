package com.example.students.controllers;

import com.example.students.exeptions.NoAvailableTeachersException;
import com.example.students.exeptions.UserDoesNotHavePermissionException;
import com.example.students.models.Group;
import com.example.students.models.Session;
import com.example.students.models.Teacher;
import com.example.students.models.User;
import com.example.students.services.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/groupsMenu")
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
        if (cookieService.isSessionPresent(request.getCookies())) {
            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());

            if (role.equals("principal")) {

                String schoolId = session.getUser().getSchool().getId();
                List<Teacher> teacherList = teacherService.findAllNotAssignedToClassBySchoolId(schoolId);
                teacherList.forEach(System.out::println);

                return new ModelAndView("/classes-menu-index")
                        .addObject("navElements", navbarService
                                .getNavbar(cookieService.getValue(request.getCookies()), sessionService))
                        .addObject("newGroup", new Group())
                        .addObject("teachers",teacherList)
                        .addObject("groups",groupService.findAllBySchoolId(schoolId));
            }
        }
        throw new UserDoesNotHavePermissionException();
    }

    @PostMapping
    public ModelAndView postGroup(@ModelAttribute Group group, HttpServletRequest request) {
        if (cookieService.isSessionPresent(request.getCookies())) {
            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("principal")) {
                groupService.save(group);
                return new ModelAndView("redirect:/groupsMenu");
            }
            return null;

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
                if( groupService.checkGroupByIdAndSchoolId(id,schoolId)){
                    groupService.deleteById(id);
                    return new ModelAndView("redirect:/groupsMenu");
                }
            }
        }
        throw new UserDoesNotHavePermissionException();
    }

}
