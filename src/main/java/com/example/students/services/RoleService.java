package com.example.students.services;

import com.example.students.models.Teacher;
import com.example.students.models.User;
import com.example.students.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {
    private final StudentRepository studentRepository;
    private final PrincipalRepository principalRepository;
    private final TeacherRepository teacherRepository;
    private final AdminRepository adminRepository;

    public boolean isStudent(User user){
        System.out.println(studentRepository.findStudentByUserId(user.getId()));
        return studentRepository.findStudentByUserId(user.getId())!=null;
    }
    public boolean isTeacher(User user){
        System.out.println(teacherRepository.findTeacherByUserId(user.getId()));
        return teacherRepository.findTeacherByUserId(user.getId())!=null;
    }
    public boolean isAdmin(User user){
        System.out.println(adminRepository.findAdminByUserId(user.getId()));

        return adminRepository.findAdminByUserId(user.getId())!=null;
    }
    public boolean isPrincipal(User user){
        System.out.println(principalRepository.findPrincipalByUserId(user.getId()));
        return principalRepository.findPrincipalByUserId(user.getId())!=null;
    }

    public String getRole(User user){
        if(isStudent(user)){
            System.out.println("student");
            return "student";
        }
        if(isTeacher(user)){
            System.out.println("teacher");
            return "teacher";
        }
        if(isAdmin(user)){
            System.out.println("admin");
            return "admin";
        }
        if(isPrincipal(user)){
            System.out.println("principal");
            return "principal";
        }
        return "";
    }
}
