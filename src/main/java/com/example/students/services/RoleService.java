package com.example.students.services;

import com.example.students.exeptions.SessionNotFoundException;
import com.example.students.models.Role;
import com.example.students.models.Session;
import com.example.students.models.User;
import com.example.students.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {
    private final StudentRepository studentRepository;
    private final PrincipalRepository principalRepository;
    private final TeacherRepository teacherRepository;
    private final AdminRepository adminRepository;
    private final SessionRepository sessionRepository;

    public boolean isStudent(User user) {
        return studentRepository.findStudentByUserId(user.getId()) != null;
    }

    public boolean isTeacher(User user) {
        return teacherRepository.findTeacherByUserId(user.getId()) != null;
    }

    public boolean isAdmin(User user) {
        return adminRepository.findAdminByUserId(user.getId()) != null;
    }

    public boolean isPrincipal(User user) {
        return principalRepository.findPrincipalByUserId(user.getId()) != null;
    }

    public Role getRole(User user) {
        if (isStudent(user)) {
            System.out.println("student");
            return Role.STUDENT;
        }
        if (isTeacher(user)) {
            System.out.println("teacher");
            return Role.TEACHER;
        }
        if (isAdmin(user)) {
            System.out.println("admin");
            return Role.ADMIN;
        }
        if (isPrincipal(user)) {
            System.out.println("principal");
            return Role.PRINCIPAL;
        }
        return null;
    }
}
