package com.example.students.repositories;

import com.example.students.models.Principal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrincipalRepository extends JpaRepository<Principal, String> {
    public Principal findPrincipalByUserId(String userId);
}
