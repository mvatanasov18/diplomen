package com.example.students.controllers;

import com.example.students.services.CookieService;
import com.example.students.services.ProjectService;
import com.example.students.services.RoleService;
import com.example.students.services.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/projectsMenu")
@AllArgsConstructor
public class ProjectMenuController {
    private final CookieService cookieService;
    private final RoleService roleService;
    private final SessionService sessionService;
    private final ProjectService projectService;


}
