package com.example.students.services;

import com.example.students.models.Team;
import com.example.students.repositories.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    public Team insertTeam(Team team){
        return teamRepository.save(team);
    }

    public void deleteTeam (Team team){
        teamRepository.delete(team);
    }
}
