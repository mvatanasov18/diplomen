package com.example.students.repositories;

import com.example.students.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
    public Admin findAdminByUserId(String userId);
}
