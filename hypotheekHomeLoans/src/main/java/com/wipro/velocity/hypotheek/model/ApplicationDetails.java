package com.wipro.velocity.hypotheek.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "applicationdetails")

@NoArgsConstructor //For Default Constructor
@AllArgsConstructor 
@Data //For Setters and Getters

public class ApplicationDetails {
	
	@Id
	private String id;
	
	private String propertyLocation;
	private String propertyName;
	private String estimatedAmount;
	private String employmentType;
	private byte age;
	private String OrganizationType;
	private String employerName;
	private float interestRate;
	private byte tenure;
	private long loanAmount;
	private boolean accept;	
	private String email;
		
}