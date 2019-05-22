package com.vtw.pulsar.user.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.vtw.pulsar.team.entity.Team;

@Entity
@Table(name="USER_TEST")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(sequenceName = "SEQ_USER", allocationSize = 1, name = "user_seq")
    private long id = 0;
    private String name;
    private String email;
    
    @CreationTimestamp
    private LocalDate join;
    
    @ManyToOne
    @JoinColumn(name="TEAM", referencedColumnName="ID")
    private Team team;
    
	public User() {
		super();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getJoin() {
		return join;
	}

	public void setJoin(LocalDate join) {
		this.join = join;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", join=" + join + ", team=" + team + "]";
	}

//	public long getTeam() {
//		return team;
//	}
//
//	public void setTeam(long team) {
//		this.team = team;
//	}

}
