package com.vtw.pulsar.team.service;

import java.util.List;

import com.vtw.pulsar.jpa.PageInfo;
import com.vtw.pulsar.team.entity.Team;

public interface TeamService {
	   
    public List<Team> getTeams(PageInfo pageInfo);
    
	public int getCount();
    
	public Team getTeam(long id);

    public void addTeam(Team team);
    
    public long generateId();

	public void updateTeam(Team team);

	public void deleteTeam(int id);
    
}
