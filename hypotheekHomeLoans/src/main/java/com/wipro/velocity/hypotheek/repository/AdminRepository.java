package com.wipro.velocity.hypotheek.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wipro.velocity.hypotheek.model.Admin;

public interface AdminRepository extends MongoRepository<Admin, String> {
   
	public Admin findByEmail(String email);
	
}