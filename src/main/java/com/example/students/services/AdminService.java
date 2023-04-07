package com.example.students.services;

import com.example.students.models.Admin;
import com.example.students.models.Teacher;
import com.example.students.repositories.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void deleteById(String groupId) {
        adminRepository.deleteById(groupId);
    }
    public List<Admin> findAllBySchoolId(String schoolId) {
        return adminRepository.findAllBySchoolId(schoolId);
    }
    public boolean checkAdminByIdAndSchoolId(String id, String schoolId) {
        List<Admin> admins = findAllBySchoolId(schoolId);
        Map<String, Admin> hashAdmins = new HashMap<>();

        for (Admin admin : admins) {
            hashAdmins.put(admin.getId(), admin);
        }

        return hashAdmins.containsKey(id);
    }
}