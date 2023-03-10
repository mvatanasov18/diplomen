package com.example.students.services;

import com.example.students.models.Team;
import com.example.students.repositories.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamService implements com.example.students.services.Service<Team> {
    private final TeamRepository teamRepository;

    @Override
    public Team save(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void delete(Team team) {
        teamRepository.delete(team);
    }

    @Override
    public Team findById(String id) {
        return teamRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Team> findAll() {
        return teamRepository.findAll();
    }
}
