package com.vtw.pulsar.user.controller;

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
import com.vtw.pulsar.user.entity.User;
import com.vtw.pulsar.user.entity.UserSearch;
import com.vtw.pulsar.user.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	UserService userService;
	
	   
    @GetMapping()
    public List<User> getUsers(PageInfo pageInfo) {

        return userService.getUsers(pageInfo);
    }
    
    @GetMapping("/conditions")
    public List<User> getUsersByConditions(UserSearch user, PageInfo pageInfo) {
    	System.out.println(user);
    	System.out.println(userService.getUsersByConditions(user, pageInfo));
    	return userService.getUsersByConditions(user, pageInfo);
    }
    
    @GetMapping("/count")
    public int getCount(UserSearch search) {

    	return userService.getCount(search);
    }
    
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
    	
        return userService.getUser((long)id);
    }

    @PostMapping()
    void addUser(@RequestBody User user) {
    	System.out.println(user);
    	userService.addUser(user);
    }
    
    @PutMapping()
    void updateUser(@RequestBody User user) {
    	
    	userService.updateUser(user);
    }
    
    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable int id) {
    	
    	userService.deleteUser(id);
    }
   	
	
	
}
