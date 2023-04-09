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
        System.out.println("vuv save");
        if (checkUser(user)) {
            System.out.println("pass");
            return userRepository.save(user);
        }
        System.out.println("vrushtam null");
        return null;
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

    public boolean checkUser(User user) {
        return (isUsernameUnique(user.getUsername()) && isEmailUnique(user.getEmail()));
    }

    private boolean isEmailUnique(String email) {
        return !userRepository.existsByEmail(email);
    }

    private boolean isUsernameUnique(String username) {
        return !userRepository.existsByUsername(username);
    }

    public void update(User changedUser, String id) {

        userRepository.update(
                changedUser.getFirstName(),
                changedUser.getLastName(),
                changedUser.getUsername(),
                changedUser.getEmail(), id);
    }

}
