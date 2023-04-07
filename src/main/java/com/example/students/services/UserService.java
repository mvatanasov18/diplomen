package com.example.students.services;

import com.example.students.exeptions.EmailAlreadyTakenException;
import com.example.students.exeptions.InvalidCredentialsException;
import com.example.students.exeptions.UsernameAlreadyTakenException;
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

        if (checkUser(user)) {
            return userRepository.save(user);
        }
        throw new IllegalArgumentException();
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
        if (isUsernameUnique(user.getUsername())
                || isEmailUnique(user.getEmail())) {
            return true;
        }

        throw  new InvalidCredentialsException();
    }

    private boolean isEmailUnique(String email) {
        return !userRepository.existsByEmail(email);
    }

    private boolean isUsernameUnique(String username) {
        return !userRepository.existsByEmail(username);
    }

    private void updateEmail(String email,String id){
        //todo: create custom query to update the email
        if(userRepository.existsByEmail(email)){
            throw new EmailAlreadyTakenException();
        }
        userRepository.updateEmail(email,id);
    }
    private void updateUsername(String username,String id){
        //todo: create custom query to update the username
        if(userRepository.existsByUsername(username)){
            throw new UsernameAlreadyTakenException();
        }
        userRepository.updateUsername(username,id);
    }

    public boolean isEmailChanged(String changedUserEmail, String databaseUserEmail){
        return !changedUserEmail.equals(databaseUserEmail);
    }
    public boolean isUsernameChanged(String changedUserUsername, String databaseUserUsername){
        return !changedUserUsername.equals(databaseUserUsername);
    }

    public void update(User changedUser, User databaseUser,String id){
        boolean flag =isEmailChanged(changedUser.getEmail(),databaseUser.getEmail());
        if(flag){
            updateEmail(changedUser.getEmail(),changedUser.getId());
        }
        if(isUsernameChanged(changedUser.getUsername(),databaseUser.getUsername())){
            updateUsername(changedUser.getUsername(),changedUser.getId());
        }
        System.out.println(changedUser);
        System.out.println(id);
        userRepository.update(changedUser.getFirstName(),changedUser.getLastName(),id);
    }
}
