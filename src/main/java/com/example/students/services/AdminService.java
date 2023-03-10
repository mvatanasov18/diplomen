package com.example.students.services;

import com.example.students.models.Admin;
import com.example.students.repositories.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService implements com.example.students.services.Service<Admin> {
    private final AdminRepository adminRepository;

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public void delete(Admin admin) {
        adminRepository.delete(admin);
    }

    @Override
    public Admin findById(String id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Admin> findAll() {
        return adminRepository.findAll();
    }
}