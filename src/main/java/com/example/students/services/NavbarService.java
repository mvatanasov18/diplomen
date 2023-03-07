package com.example.students.services;

import com.example.students.models.Navbar;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


@Service
@AllArgsConstructor
public class NavbarService {

    private final SessionService sessionService;
    private  final CookieService cookieService;

//future idea if there is time:
//statistics about the school
    private Map<String,String> setMapForPrincipal(){
        Map<String,String> elemets = new TreeMap<>();
        elemets.put("/students","Students Menu");
        elemets.put("/teachers","Teachers Menu");
        elemets.put("/school","School Menu");
        elemets.put("/profile","Profile");
        return elemets;
    }
    private Map<String,String> setMapForStudent(){
        Map<String,String> elemets = new TreeMap<>();
        elemets.put("/calendar","Calendar");
        elemets.put("/tasks","Tasks");
        elemets.put("/projects","Projects");
        elemets.put("/teams","Teams");
        elemets.put("/profile","Profile");
        return elemets;
    }
    private Map<String,String> setMapForTeacher(){
        Map<String,String> elemets = new TreeMap<>();
        elemets.put("/tasksMenu","Tasks Menu");
        elemets.put("/projectsMenu","Projects Menu");
        elemets.put("/teamsMenu","Teams Menu");
        elemets.put("/profile","Profile");
        return elemets;
    }
    private Map<String,String> setMapForAdmin(){
        Map<String,String> elemets = new TreeMap<>();
        elemets.put("/students","Students Menu");
        elemets.put("/projectsMenu","Projects Menu");
        elemets.put("/teamsMenu","Teams Menu");
        elemets.put("/profile","Profile");
        return elemets;
    }
    private Navbar getNavbarByRoleName(String roleName){

        return switch (roleName) {
            case "principal" -> new Navbar(setMapForPrincipal());
            case "student" -> new Navbar(setMapForStudent());
            case "admin" -> new Navbar(setMapForAdmin());
            case "teacher" -> new Navbar(setMapForTeacher());
            default -> null;
        };

    }

    public Navbar getNavbar(HttpServletRequest request){


        String sessionId = cookieService.getValue(request.getCookies());
        if(sessionId.equals("")) {
            Map<String,String> temp=new TreeMap<>();
            temp.put("/login","Login");
            temp.put("/register","Register");
            temp.put("/","Home");
            return new Navbar(temp);


        }else{
            return  getNavbarByRoleName(sessionService.findById(sessionId).getRoleName());
        }
    }
}
