package com.example.students.services;

import com.example.students.models.User;
import com.example.students.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    public User saveUser(User user){
        return userRepository.save(user);
    }
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public boolean checkPassword(User user, String providedPassword){
        return user.getPassword().equals(providedPassword);
    }
    public User findById(String id){
        return userRepository.findById(id).orElse(null);
    }
}
