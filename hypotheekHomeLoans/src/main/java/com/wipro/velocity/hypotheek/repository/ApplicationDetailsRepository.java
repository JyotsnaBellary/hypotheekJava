package com.wipro.velocity.hypotheek.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wipro.velocity.hypotheek.model.ApplicationDetails;

public interface ApplicationDetailsRepository extends MongoRepository<ApplicationDetails, String> {
	public ApplicationDetails findByEmail(String email);
}