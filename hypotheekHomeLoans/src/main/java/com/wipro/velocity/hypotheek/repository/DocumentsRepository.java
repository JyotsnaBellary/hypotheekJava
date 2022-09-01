package com.wipro.velocity.hypotheek.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wipro.velocity.hypotheek.model.Documents;

public interface DocumentsRepository extends MongoRepository<Documents, String> {

	public List<Documents> findByEmail(String email);
	
	
}