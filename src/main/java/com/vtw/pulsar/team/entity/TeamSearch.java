package com.vtw.pulsar.team.entity;

public class TeamSearch {
	
	private long id = 0;
	private String name = "";
	
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
	
	@Override
	public String toString() {
		return "TeamSearch [id=" + id + ", name=" + name + "]";
	}

}
