package com.vtw.pulsar.team.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vtw.pulsar.jpa.PageInfo;
import com.vtw.pulsar.team.entity.Team;
import com.vtw.pulsar.team.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService {

	private final TeamRepository teamRepository;
    
    public TeamServiceImpl(TeamRepository teamRepository) {
    	this.teamRepository = teamRepository;
    }
    
    public List<Team> getTeams(PageInfo pageInfo) {
    	
        return (List<Team>) teamRepository.findAll(pageInfo.toPageable("id")).getContent();
    }
    
	public int getCount() {
		
		return (int) teamRepository.count();
	}
    
	public Team getTeam(long id) {

		return teamRepository.findById(id).get();
	}

    public void addTeam(Team team) {
    	
    	if(team.getId() == 0) {
    		//team.setId(generateId());
    	}
    	
    	teamRepository.save(team);
    }
    
    public long generateId() {
    	
    	return 0;
    }

	public void updateTeam(Team team) {

		teamRepository.save(team);
	}

	public void deleteTeam(Team team) {

		teamRepository.delete(team);
	}
    
    
}
