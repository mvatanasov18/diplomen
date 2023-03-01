package com.example.students.services;

import com.example.students.models.FileEntity;
import com.example.students.models.Group;
import com.example.students.repositories.FileEntityRepository;
import com.example.students.repositories.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class GroupService {
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository){
        this.groupRepository =groupRepository;
    }

    public Group saveGroup(Group group){
        return groupRepository.save(group);
    }
    public void deleteGroup(Group group){
        groupRepository.delete(group);
    }
    public Optional<Group> findById(String id){
        return groupRepository.findById(id);
    }
    public Iterable<Group> findAll(){
        return groupRepository.findAll();
    }
}