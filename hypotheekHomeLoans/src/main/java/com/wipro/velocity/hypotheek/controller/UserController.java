package com.wipro.velocity.hypotheek.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import com.wipro.velocity.hypotheek.model.ApplicationDetails;
import com.wipro.velocity.hypotheek.model.User;

import com.wipro.velocity.hypotheek.repository.ApplicationDetailsRepository;
import com.wipro.velocity.hypotheek.repository.UserRepository;

import com.wipro.velocity.hypotheek.service.ApplicationDetailsService;
import com.wipro.velocity.hypotheek.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

	@Autowired 
	private UserRepository userrepo;
	
	@Autowired
	private UserService userv;
	
	@Autowired
	private ApplicationDetailsService appserv;
	
	@Autowired
	private ApplicationDetailsRepository apprepo;
	
	String email;
	long loan;
	
	//POST-http://localhost:8989/dhl/api/registerUser
	@PostMapping("/registerUser")
    public String saveUser(@RequestBody User user){
        userrepo.save(user);
       
        return "User Added Successfully";
    }
	
	//DELETE--http://localhost:8989/dhl/api/register/delete/{id}
	@DeleteMapping("register/delete/{id}")
    public String deleteUser(@PathVariable String id){
        userrepo.deleteById(id);
       
        return "Deleted Successfully";
    }
	
	//GET--http://localhost:8989/dhl/api/findAllUsers
	@GetMapping("/findAllUsers")
    public List<User> getUsers() {
       
        return userrepo.findAll();
    }

	//GET--http://localhost:8989/dhl/api/findByEmail/{emailId}
	 @GetMapping("/findByEmail/{emailId}")
	    public User findUser(@PathVariable String emailId){
	    	return userrepo.findByEmailId(emailId);
	 }
	 
	//GET--http://localhost:8989/dhl/api/findByAcc/{accNo}
	 @GetMapping("/findByAcc/{accNo}")
	    public User findUserbyAcc(@PathVariable String accNo){
	    	return userrepo.findByAccountNumber(accNo);
	 }
	 
	 
	 //POST--//GET--http://localhost:8989/dhl/api/loginUser
	 @PostMapping("/loginUser")
	    public Boolean loginUser(@Validated @RequestBody User user) 
	    {
	        Boolean isLogin=false;
	        String emailId=user.getEmailId();
	        String password=user.getPassword();
	        
	        User u = userrepo.findByEmailId(emailId);
	       
	        if(emailId.equals(u.getEmailId()) && password.equals(u.getPassword()))
	                {
	        
	            isLogin=true;
	           
	                }
	        return isLogin;
	    }
	 
	 //PUT--http://localhost:8989/dhl/api/update
	 
	 @PutMapping("/update")
	 public String updateUser(@RequestParam("id") String id, @RequestParam("status") boolean status) {
		 User user = userv.getUserById(id);
		 System.out.println("Inside update");
		 if(!user.getEmailId().isEmpty()) { // condition is false
			 System.out.println("user found"); 
			 email = user.getEmailId();
			 ApplicationDetails appln = apprepo.findByEmail(email);
			 
			 if(user.getAccountNumber() == null) {
				 System.out.println("acc doesn't exists");
				 user.setAccountNumber(UUID.randomUUID().toString().substring(0, 8));
				 user.setBalance(String.valueOf(appln.getLoanAmount()));
			 }
			 else {
				System.out.println("acc exists");
				loan = Long.valueOf(appln.getLoanAmount());
				Long balance = Long.valueOf(user.getBalance());
				balance = balance + loan;
				user.setBalance(String.valueOf(balance));
			 }
//			 appln.setAccept(status);
			 user.setAccept(status);
			 userrepo.save(user);
//			 apprepo.save(appln);
//			 
		 }else {
			 System.out.println("user not found");
		 }
		 return "Updated";
	 }
}