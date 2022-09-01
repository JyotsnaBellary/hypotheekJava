package com.wipro.velocity.hypotheek.controller;

import com.wipro.velocity.hypotheek.model.ApplicationDetails;
import com.wipro.velocity.hypotheek.model.User;
import com.wipro.velocity.hypotheek.repository.ApplicationDetailsRepository;
import com.wipro.velocity.hypotheek.service.ApplicationDetailsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class ApplicationDetailsController {
	
	@Autowired
	private ApplicationDetailsRepository appdetailsrepo;
	
	@Autowired
	private ApplicationDetailsService appserv;
	
	//POST--http://localhost:8989/dhl/api/addDetails
	@PostMapping("/addDetails")
    public String saveDetails(@RequestBody ApplicationDetails app){
        appdetailsrepo.save(app);
       
        return "Added Successfully";
    }
	
	//GetT--http://localhost:8989/dhl/api/getDetails
		@GetMapping("/getDetails/{emailId}")
	    public ApplicationDetails getapplnbyemail(@PathVariable String emailId){
			ApplicationDetails appln = appdetailsrepo.findByEmail(emailId);
			return appln;
		 
	    }
}