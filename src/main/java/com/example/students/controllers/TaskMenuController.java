package com.example.students.controllers;

import com.example.students.services.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/tasksMenu")
@AllArgsConstructor
public class TaskMenuController {
    private final CookieService cookieService;
    private final RoleService roleService;
    private final SessionService sessionService;
    private final TaskService taskService;


}
