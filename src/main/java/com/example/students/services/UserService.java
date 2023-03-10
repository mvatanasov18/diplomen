package com.example.students.services;

import com.example.students.models.User;
import com.example.students.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements com.example.students.services.Service<User> {
    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean checkPassword(User user, User loginUser) {
        return user.getPassword().equals(loginUser.getPassword());
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public boolean checkEmailAndUsername(User user) {
        return userRepository.existsByEmail(user.getEmail()) || userRepository.existsByUsername(user.getUsername());
    }
}
