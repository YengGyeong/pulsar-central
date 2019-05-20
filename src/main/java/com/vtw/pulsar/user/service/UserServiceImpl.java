package com.vtw.pulsar.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vtw.pulsar.jpa.PageInfo;
import com.vtw.pulsar.user.entity.User;
import com.vtw.pulsar.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository) {
    	this.userRepository = userRepository;
    }
    
    public List<User> getUsers(PageInfo pageInfo) {
    	
        return (List<User>) userRepository.findAll(pageInfo.toPageable("id")).getContent();
    }
    
	public int getCount() {
		
		return (int) userRepository.count();
	}
    
	public User getUser(long id) {

		return userRepository.findById(id).get();
	}

    public void addUser(User user) {
    	
    	if(user.getId() == 0) {
    		//user.setId(generateId());
    	}
    	
    	userRepository.save(user);
    }
    
    public long generateId() {
    	
    	return 0;
    }

	public void updateUser(User user) {

		userRepository.save(user);
	}

	public void deleteUser(User user) {

		userRepository.delete(user);
	}
    
}