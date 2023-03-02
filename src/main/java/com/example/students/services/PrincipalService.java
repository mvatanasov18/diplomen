package com.example.students.services;

import com.example.students.models.Address;
import com.example.students.models.Principal;
import com.example.students.models.School;
import com.example.students.models.User;
import com.example.students.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrincipalService {


    private final PrincipalRepository principalRepository;
    @Autowired
    public PrincipalService(PrincipalRepository principalRepository){
        this.principalRepository=principalRepository;
    }

    public Principal updatePrincipal(Principal principal){
        return principalRepository.save(principal);
    }

    public boolean insertPrincipal(Principal principal){
        try {

            principalRepository.save(principal);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Principal findPrincipalByUserId(String id){
        return principalRepository.findPrincipalByUserId(id);
    }
    public Principal findById(String id){
        return principalRepository.findById(id).orElse(null);
    }

}
