package com.example.students.services;

import com.example.students.models.Teacher;
import com.example.students.models.User;
import com.example.students.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final StudentRepository studentRepository;
    private final PrincipalRepository principalRepository;
    private final TeacherRepository teacherRepository;
    private final AdminRepository adminRepository;

    @Autowired
    public RoleService(StudentRepository studentRepository,
                       PrincipalRepository principalRepository,
                       TeacherRepository teacherRepository,
                       AdminRepository adminRepository){
        this.studentRepository=studentRepository;
        this.principalRepository=principalRepository;
        this.teacherRepository=teacherRepository;
        this.adminRepository=adminRepository;
    }

    public boolean isStudent(User user){
        return studentRepository.findById(user.getId()).isPresent();
    }
    public boolean isTeacher(User user){
        return teacherRepository.findById(user.getId()).isPresent();
    }
    public boolean isAdmin(User user){
        return adminRepository.findById(user.getId()).isPresent();
    }
    public boolean isPrincipal(User user){
        return principalRepository.findById(user.getId()).isPresent();
    }
}
