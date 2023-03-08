package com.example.students.services;

import com.example.students.models.Address;
import com.example.students.models.Principal;
import com.example.students.models.School;
import com.example.students.models.User;
import com.example.students.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PrincipalService {


    private final PrincipalRepository principalRepository;

    public Principal updatePrincipal(Principal principal){
        return principalRepository.save(principal);
    }

    public Principal insertPrincipal(Principal principal){

          return  principalRepository.save(principal);

    }

    public Principal findPrincipalByUserId(String id){
        return principalRepository.findPrincipalByUserId(id);
    }
    public Principal findById(String id){
        return principalRepository.findById(id).orElse(null);
    }

}
