package com.vtw.pulsar.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vtw.pulsar.jpa.PageInfo;
import com.vtw.pulsar.user.entity.User;

@Service
public interface UserService {
	   
    public List<User> getUsers(PageInfo pageInfo);
    
	public int getCount();
    
	public User getUser(long id);

    public void addUser(User user);
    
    public long generateId();

	public User updateUser(User user);

	public void deleteUser(int id);

	public List<User> getUsersByConditions();
    
}
