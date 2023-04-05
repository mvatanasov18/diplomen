package com.example.students.services;

import com.example.students.exeptions.UserNotFoundException;
import com.example.students.models.Teacher;
import com.example.students.repositories.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class TeacherService implements com.example.students.services.Service<Teacher> {
    private final TeacherRepository teacherRepository;


    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        teacherRepository.delete(teacher);
    }

    @Override
    public Teacher findById(String id) {
        return teacherRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public Iterable<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher findByUserId(String id) {
        return teacherRepository.findTeacherByUserId(id);
    }

    public List<Teacher> findAllNotAssignedToClassBySchoolId(String id) {
        return teacherRepository.findAllNotAssignedToClassBySchoolId(id);
    }

    public void deleteById(String groupId) {
        teacherRepository.deleteById(groupId);
    }

    public List<Teacher> findAllBySchoolId(String schoolId) {
        return teacherRepository.findAllBySchoolId(schoolId);
    }

    public boolean checkGroupByIdAndSchoolId(String id, String schoolId) {
        List<Teacher> teachers = findAllBySchoolId(schoolId);
        Map<String, Teacher> hashTeachers = new HashMap<>();

        for (Teacher teacher : teachers) {
            hashTeachers.put(teacher.getId(), teacher);
        }

        return hashTeachers.containsKey(id);
    }
}
