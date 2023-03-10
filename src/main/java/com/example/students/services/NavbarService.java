package com.example.students.services;

import com.example.students.models.Navbar;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


@Service
@AllArgsConstructor
public class NavbarService {

    //future idea if there is time:
    //statistics about the school
    private Map<String, String> setMapForPrincipal() {
        Map<String, String> elements = new HashMap<>();

        elements.put("/profile", "Profile");
        elements.put("/login/logout", "Logout");
        elements.put("/students", "Students Menu");
        elements.put("/teachers", "Teachers Menu");
        elements.put("/school", "School Menu");

        return elements;
    }

    private Map<String, String> setMapForStudent() {
        Map<String, String> elements = new HashMap<>();
        elements.put("/login/logout", "Logout");
        elements.put("/profile", "Profile");
        elements.put("/calendar", "Calendar");
        elements.put("/tasks", "Tasks");
        elements.put("/projects", "Projects");
        elements.put("/teams", "Teams");

        return elements;
    }

    private Map<String, String> setMapForTeacher() {
        Map<String, String> elements = new HashMap<>();
        elements.put("/login/logout", "Logout");
        elements.put("/profile", "Profile");
        elements.put("/tasksMenu", "Tasks Menu");
        elements.put("/projectsMenu", "Projects Menu");
        elements.put("/teamsMenu", "Teams Menu");
        return elements;
    }

    private Map<String, String> setMapForAdmin() {
        Map<String, String> elements = new HashMap<>();
        elements.put("/login/logout", "Logout");
        elements.put("/profile", "Profile");
        elements.put("/students", "Students Menu");
        elements.put("/projectsMenu", "Projects Menu");
        elements.put("/teamsMenu", "Teams Menu");
        return elements;
    }

    private Navbar getNavbarByRoleName(String roleName) {

        return switch (roleName) {
            case "principal" -> new Navbar(setMapForPrincipal());
            case "student" -> new Navbar(setMapForStudent());
            case "admin" -> new Navbar(setMapForAdmin());
            case "teacher" -> new Navbar(setMapForTeacher());
            default -> null;
        };

    }

    public Navbar getNavbar(String sessionId, SessionService sessionService) {

        if (sessionId.equals("")) {
            Map<String, String> temp = new TreeMap<>();
            temp.put("/login", "Login");
            temp.put("/register", "Register");
            temp.put("/", "Home");
            return new Navbar(temp);


        } else {
            return getNavbarByRoleName(sessionService.findById(sessionId).getRoleName());
        }
    }
}
