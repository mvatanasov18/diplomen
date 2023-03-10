package com.example.students.services;

import com.example.students.models.Principal;
import com.example.students.repositories.PrincipalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PrincipalService implements com.example.students.services.Service<Principal> {


    private final PrincipalRepository principalRepository;

    @Override
    public Principal save(Principal principal) {
        return principalRepository.save(principal);
    }

    @Override
    public void delete(Principal principal) {
        principalRepository.delete(principal);
    }

    public Principal findPrincipalByUserId(String id) {
        return principalRepository.findPrincipalByUserId(id);
    }

    @Override
    public Principal findById(String id) {
        return principalRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Principal> findAll() {
        return null;
    }

}
