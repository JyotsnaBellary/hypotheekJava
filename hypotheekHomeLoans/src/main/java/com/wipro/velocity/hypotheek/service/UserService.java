package com.wipro.velocity.hypotheek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.velocity.hypotheek.model.User;
import com.wipro.velocity.hypotheek.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository urepo;
	
	public User getUserById(String id) 
	 { 
	        return urepo.findById(id).get(); 
	 }
}
