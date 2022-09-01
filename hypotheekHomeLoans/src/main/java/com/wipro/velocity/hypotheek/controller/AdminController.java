package com.wipro.velocity.hypotheek.controller;

import java.util.List;
import java.util.Optional;

import com.wipro.velocity.hypotheek.model.Admin;

import com.wipro.velocity.hypotheek.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class AdminController {
	

	@Autowired //connecting component to other components
	private AdminRepository arepo;
	
	//POST--http://localhost:8989//dhl/api/registerAdmin
	@PostMapping("/registerAdmin")
    public String saveBook(@RequestBody Admin admin){
        arepo.save(admin);
       
        return "Added Successfully";
    }
 
	
	//GET--http://localhost:8989/dhl/api/findAllAdmins
    @GetMapping("/findAllAdmins")
    public List<Admin> getAdmin() {
       
        return arepo.findAll();
    }
 
    //DELETE--http://localhost:8989/dhl/api/delete/{id}
    
    @DeleteMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable String id){
    	
    	arepo.deleteById(id);
       
        return "Deleted Successfully";
    }
    
    
    //GET--http://localhost:8989/dhl/api/findById/{id}
    @GetMapping("/findById/{id}")
    public Optional<Admin> findAdmin(@PathVariable String id){
    	return arepo.findById(id);
    }
    
    
  //POST--http://localhost:8989/dhl/api/loginAdmin
    @PostMapping("/loginAdmin")
    public Boolean loginAdmin(@Validated @RequestBody Admin admin)
    {
        Boolean isLogin=false;
        String email=admin.getEmail();
        String password=admin.getPassword();
        //System.out.println(email+password);
        Admin a = arepo.findByEmail(email);
       
        if(email.equals(a.getEmail()) && password.equals(a.getPassword()))
                {
        //    System.out.println(d.getEmail() +d.getPassword() );
            isLogin=true;
           
                }
        return isLogin;
    }
    
}