package com.wipro.velocity.hypotheek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.velocity.hypotheek.model.ApplicationDetails;
import com.wipro.velocity.hypotheek.repository.ApplicationDetailsRepository;


@Service
public class ApplicationDetailsService {

	@Autowired
	private ApplicationDetailsRepository arepo;
	
	public ApplicationDetails getappById(String id) 
	 { 
	        return arepo.findById(id).get();
	 }
}
