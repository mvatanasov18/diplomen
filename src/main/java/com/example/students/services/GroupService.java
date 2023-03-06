package com.example.students.services;

import com.example.students.models.FileEntity;
import com.example.students.models.Group;
import com.example.students.repositories.FileEntityRepository;
import com.example.students.repositories.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public Group saveGroup(Group group){
        return groupRepository.save(group);
    }
    public void deleteGroup(Group group){
        groupRepository.delete(group);
    }
    public Group findById(String id){
        return groupRepository.findById(id).orElse(null);
    }
    public Iterable<Group> findAll(){
        return groupRepository.findAll();
    }
}