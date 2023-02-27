package com.example.students.services;

import com.example.students.models.User;
import com.example.students.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserJdbcTemplateRepository userJdbcTemplateRepository;
    private final RoleService roleService;

    @Autowired
    public UserService(UserRepository userRepository,
                       UserJdbcTemplateRepository userJdbcTemplateRepository,
                       RoleService roleService){
        this.userRepository=userRepository;
        this.userJdbcTemplateRepository=userJdbcTemplateRepository;
        this.roleService=roleService;
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public boolean saveSessionForUser(String token, String username){
        try {
            userJdbcTemplateRepository.saveSessionByUsername(token, username);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean checkPassword(User user, String providedPassword){
        return user.getPassword().equals(providedPassword);
    }
    public String getRole(User user){
        if(roleService.isStudent(user)){
            return "student";
        }
        if(roleService.isTeacher(user)){
            return "teacher";
        }
        if(roleService.isAdmin(user)){
            return "admin";
        }
        if(roleService.isPrincipal(user)){
            return "principal";
        }
        return "";
    }
}
