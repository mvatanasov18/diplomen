package com.example.students.services;

import com.example.students.models.Admin;
import com.example.students.models.School;
import com.example.students.repositories.AdminRepository;
import com.example.students.repositories.SchoolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminService implements com.example.students.services.Service<Admin> {
    private final AdminRepository adminRepository;

    public Admin save(Admin admin){
        return adminRepository.save(admin);
    }
    public void delete(Admin admin){
        adminRepository.delete(admin);
    }
    public Admin findById(String id){
        return adminRepository.findById(id).orElse(null);
    }
    public Iterable<Admin> findAll(){
        return adminRepository.findAll();
    }
}