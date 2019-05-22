package com.vtw.pulsar.team.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vtw.pulsar.jpa.PageInfo;
import com.vtw.pulsar.team.entity.Team;
import com.vtw.pulsar.team.entity.TeamSearch;
import com.vtw.pulsar.team.repository.TeamRepository;
import com.vtw.pulsar.team.repository.TeamSpecification;

@Service
public class TeamServiceImpl implements TeamService {

	private final TeamRepository teamRepository;
    
    public TeamServiceImpl(TeamRepository teamRepository) {
    	this.teamRepository = teamRepository;
    }
    
    public List<Team> getTeams(TeamSearch team, PageInfo pageInfo) {
    	
        return (List<Team>) teamRepository.findAll(TeamSpecification.searchTeam(team), pageInfo.toPageable("id")).getContent();
    }
    
	public int getCount(TeamSearch team) {
		
		return (int) teamRepository.count(TeamSpecification.searchTeam(team));
	}
    
	public Team getTeam(long id) {

		return teamRepository.findById(id).get();
	}

    public void addTeam(Team team) {
    	
    	if(team.getId() == -1) {
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

	public void deleteTeam(int id) {

		teamRepository.deleteById((long)id);
	}
    
    
}
