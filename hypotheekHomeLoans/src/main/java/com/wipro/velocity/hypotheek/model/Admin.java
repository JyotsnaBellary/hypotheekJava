package com.wipro.velocity.hypotheek.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection="admin")
@NoArgsConstructor //For Default Constructor
@AllArgsConstructor //
@Data //For Setters and Getters
public class Admin {

	@Id
	private String id;
	
	private String email;
	
	private String password;
	
	

}