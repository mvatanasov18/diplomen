package com.example.students.services;

import com.example.students.models.Admin;
import com.example.students.models.School;
import com.example.students.repositories.AdminRepository;
import com.example.students.repositories.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository){
        this.adminRepository=adminRepository;
    }

    public Admin saveAdmin(Admin admin){
        return adminRepository.save(admin);
    }
    public void deleteAdmin(Admin admin){
        adminRepository.delete(admin);
    }
    public Admin findById(String id){
        return adminRepository.findById(id).orElse(null);
    }
    public Iterable<Admin> findAll(){
        return adminRepository.findAll();
    }
}