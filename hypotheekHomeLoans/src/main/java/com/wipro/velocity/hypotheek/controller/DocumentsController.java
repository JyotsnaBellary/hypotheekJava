package com.wipro.velocity.hypotheek.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//import com.wipro.velocity.hypotheek.message.ResponseFile;
//import com.wipro.velocity.hypotheek.message.ResponseMessage;
import com.wipro.velocity.hypotheek.model.Documents;
import com.wipro.velocity.hypotheek.service.DocumentsService;


@RestController

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class DocumentsController {
  @Autowired
  private DocumentsService sv;
  
 
  
  @PostMapping("/upload")
  public String uploadFile(@RequestParam("panFile") MultipartFile panFile, @RequestParam("voterFile") MultipartFile voterFile,
		  @RequestParam("salaryFile") MultipartFile salaryFile, @RequestParam("loaFile") MultipartFile loaFile,
		  @RequestParam("nocFile") MultipartFile nocFile, @RequestParam("agreementFile") MultipartFile agreementFile, 
		  @RequestParam("panUrl") String panUrl, @RequestParam("voterUrl") String voterUrl,
		  @RequestParam("salaryUrl") String salaryUrl, @RequestParam("loaUrl") String loaUrl,
		  @RequestParam("nocUrl") String nocUrl, @RequestParam("agreementUrl") String agreementUrl, @RequestParam("email") String email, Model model) throws IOException{
    
	  System.out.println("Inside upload");
	  String id = sv.addFiles(panFile, voterFile, salaryFile, loaFile, nocFile, agreementFile,
			                  panUrl, voterUrl, salaryUrl, loaUrl, nocUrl, agreementUrl, email);
	  
	  return "Files added successfully" + id;
  }
  
  
  @GetMapping("/files")
  public List<Documents> getListFiles() {
    return sv.getDocumentsList();
  }
  
  
  @GetMapping("/files/{id}")
  public ResponseEntity<Documents> getFile(@PathVariable String id) {
    Documents doc = sv.getFile(id);
    return ResponseEntity.ok().body(doc);
        
  }
  
  @GetMapping("/documents/{emailId}")
	public List<Documents> getDocuments(@PathVariable(value="emailId") String emailId)
	{
		return sv.getDocuments(emailId);  //invokes findAll() method of MongoRepository
	}
  
  
}