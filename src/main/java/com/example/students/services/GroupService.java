package com.example.students.services;

import com.example.students.models.Group;
import com.example.students.repositories.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@AllArgsConstructor
public class GroupService implements com.example.students.services.Service<Group> {
    private final GroupRepository groupRepository;

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public void delete(Group group) {
        groupRepository.delete(group);
    }

    @Override
    public Group findById(String id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Group> findAll() {
        return groupRepository.findAll();
    }

    public List<Group> findAllBySchoolId(String id) {
        return groupRepository.findAllBySchoolId(id);
    }
    public void deleteById(String groupId) {
        groupRepository.deleteById(groupId);
    }

    public boolean checkGroupByIdAndSchoolId(String id,String schoolId){
        List<Group> groups =  findAllBySchoolId(schoolId);
        Map<String,Group> hashGroups =new HashMap<>();

        for(Group group:groups){
            hashGroups.put(group.getId(), group);
        }

        return  hashGroups.containsKey(id);
    }

    public Group findAllByGradeAndLetterAndSchoolId(int grade, char letter,String schoolId){
        return groupRepository.findAllByGradeAndLetterAndSchoolId(grade,letter,schoolId);
    }
}