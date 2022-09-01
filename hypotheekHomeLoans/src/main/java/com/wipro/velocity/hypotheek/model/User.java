package com.wipro.velocity.hypotheek.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="User")

@NoArgsConstructor //For Default Constructor
@AllArgsConstructor //
@Data //For Setters and Getters
public class User {

	@Id
	private String id;
	
	private String  firstName;
	
	private String  lastName;
	private String  emailId;
	private String  password;
	private long    phoneNumber;
	private Date    dob;
	
	private String gender;
	
	private Long     adharNumber;
	private String panNumber;
	
	private boolean accept;	
	private String accountNumber;
	private String balance;
}