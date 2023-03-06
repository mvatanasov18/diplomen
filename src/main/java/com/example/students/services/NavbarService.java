package com.example.students.services;

import com.example.students.models.Navbar;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class NavbarService {

//future idea if there is time:
//statistics about the school
    private Map<String,String> setMapForPrincipal(){
        Map<String,String> elemets = new HashMap<>();
        elemets.put("/students","Students Menu");
        elemets.put("/teachers","Teachers Menu");
        elemets.put("/school","School Menu");
        elemets.put("/profile","Profile");
        return elemets;
    }
    private Map<String,String> setMapForStudent(){
        Map<String,String> elemets = new HashMap<>();
        elemets.put("/calendar","Calendar");
        elemets.put("/tasks","Tasks");
        elemets.put("/projects","Projects");
        elemets.put("/teams","Teams");
        elemets.put("/profile","Profile");
        return elemets;
    }
    private Map<String,String> setMapForTeacher(){
        Map<String,String> elemets = new HashMap<>();
        elemets.put("/tasksMenu","Tasks Menu");
        elemets.put("/projectsMenu","Projects Menu");
        elemets.put("/teamsMenu","Teams Menu");
        elemets.put("/profile","Profile");
        return elemets;
    }
    private Map<String,String> setMapForAdmin(){
        Map<String,String> elemets = new HashMap<>();
        elemets.put("/students","Students Menu");
        elemets.put("/projectsMenu","Projects Menu");
        elemets.put("/teamsMenu","Teams Menu");
        elemets.put("/profile","Profile");
        return elemets;
    }
    public Navbar getNavbarByRoleName(String roleName){

        return switch (roleName) {
            case "principal" -> new Navbar(setMapForPrincipal());
            case "student" -> new Navbar(setMapForStudent());
            case "admin" -> new Navbar(setMapForAdmin());
            case "teacher" -> new Navbar(setMapForTeacher());
            default -> null;
        };

    }


}
