package com.example.students.services;

import com.example.students.models.Navbar;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


@Service
@AllArgsConstructor
public class NavbarService {

    //future idea if there is time:
    //statistics about the school
    private Map<String, String> setMapForPrincipal() {
        Map<String, String> elements = new LinkedHashMap<>();
        elements.put("/school", "Промяна на училищни данни");
        elements.put("/adminsMenu", "Меню за администрация");
        elements.put("/teachersMenu", "Меню за учителите");
        elements.put("/groupsMenu", "Меню за класовете");
        elements.put("/studentsMenu", "Меню за учениците");
        elements.put("/profile", "Профил");
        elements.put("/login/logout", "Излез");

        return elements;
    }

    private Map<String, String> setMapForStudent() {
        Map<String, String> elements = new LinkedHashMap<>();
        elements.put("/teams", "Отбори");
        elements.put("/projects", "Проекти");
        elements.put("/tasks", "Домашни работи");
        elements.put("/calendar", "Календар");
        elements.put("/profile", "Профил");
        elements.put("/login/logout", "Излез");

        return elements;
    }

    private Map<String, String> setMapForTeacher() {
        Map<String, String> elements = new LinkedHashMap<>();
        elements.put("/teamsMenu", "Меню за отборите");
        elements.put("/projectsMenu", "Меню за проектите");
        elements.put("/tasksMenu", "Меню за домашните");
        elements.put("/profile", "Профил");
        elements.put("/login/logout", "Излез");
        return elements;
    }

    private Map<String, String> setMapForAdmin() {
        Map<String, String> elements = new LinkedHashMap<>();
        elements.put("/groupsMenu", "Меню за класовете");
        elements.put("/studentsMenu", "Меню за учениците");
        elements.put("/teamsMenu", "Меню за отборите");
        elements.put("/projectsMenu", "Меню за проектите");
        elements.put("/profile", "Профил");
        elements.put("/login/logout", "Излез");

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
            temp.put("/login", "Вписване");
            temp.put("/register", "Регистрация");
            temp.put("/", "Начало");
            return new Navbar(temp);


        } else {
            return getNavbarByRoleName(sessionService.findById(sessionId).getRoleName());
        }
    }
}
