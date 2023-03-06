package com.example.students.services;

import com.example.students.models.User;
import com.example.students.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

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
