package com.example.students.services;

import com.example.students.models.Group;
import com.example.students.repositories.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


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

}