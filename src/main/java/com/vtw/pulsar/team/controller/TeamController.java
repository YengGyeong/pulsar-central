package com.vtw.pulsar.team.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtw.pulsar.jpa.PageInfo;
import com.vtw.pulsar.team.entity.Team;
import com.vtw.pulsar.team.service.TeamServiceImpl;

@RestController
@RequestMapping("/teams")
@CrossOrigin(origins = "http://localhost:4200")
public class TeamController {

	@Autowired
	TeamServiceImpl teamService;	
    
    @GetMapping()
    public List<Team> getTeams(PageInfo pageInfo) {

        return teamService.getTeams(pageInfo);
    }
    
    @GetMapping("/count")
    public int getCount() {
    	
    	return teamService.getCount();
    }
    
    @GetMapping("/{id}")
    public Team getTeam(@PathVariable int id) {
    	
        return teamService.getTeam((long)id);
    }

    @PostMapping()
    void addTeam(@RequestBody Team team) {
    	
    	teamService.addTeam(team);
    }
    
    @PutMapping()
    void updateTeam(@RequestBody Team team) {
    	
    	teamService.updateTeam(team);
    }
    
    @DeleteMapping()
    void deleteTeam(@RequestBody Team team) {
    	
    	teamService.deleteTeam(team);
    }
      
}
