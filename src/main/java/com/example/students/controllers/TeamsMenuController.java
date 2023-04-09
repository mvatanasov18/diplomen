package com.example.students.controllers;

import com.example.students.exeptions.UserDoesNotHavePermissionException;
import com.example.students.models.Admin;
import com.example.students.models.Session;
import com.example.students.services.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/teamsMenu")
@AllArgsConstructor
public class TeamsMenuController {
    private final TeamService teamService;
    private final CookieService cookieService;
    private final RoleService roleService;
    private final SessionService sessionService;
    private final ProjectService projectService;
    private final NavbarService navbarService;

    @GetMapping
    public ModelAndView getTeams(HttpServletRequest request){

        if (cookieService.isSessionPresent(request.getCookies())) {

            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("admin")||role.equals("teacher")) {

                return new ModelAndView("/teams-menu-index")
                        .addObject("navElements", navbarService
                                .getNavbar(cookieService.getValue(request.getCookies()), sessionService))
                        .addObject("teams",teamService.findAllBySchoolId(session.getUser().getSchool().getId()));

            }
        }
        throw new UserDoesNotHavePermissionException();
    }
}
