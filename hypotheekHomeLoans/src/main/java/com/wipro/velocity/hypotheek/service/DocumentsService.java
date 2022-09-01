package com.wipro.velocity.hypotheek.service;




import java.io.IOException;
//import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.wipro.velocity.hypotheek.model.Documents;
import com.wipro.velocity.hypotheek.repository.DocumentsRepository;

 
@Service
public class DocumentsService {
  @Autowired
  private DocumentsRepository dr;
  
  public String addFiles(MultipartFile panFile,MultipartFile voterFile,MultipartFile salaryFile,MultipartFile loaFile,MultipartFile nocFile,MultipartFile agreementFile,
          String panUrl,String voterUrl,String salaryUrl,String loaUrl,String nocUrl,String agreementUrl,String email) throws IOException
  {
	  Documents doc = new Documents();
	  doc.setPanFile(new Binary(BsonBinarySubType.BINARY, panFile.getBytes()));
	  doc.setVoterFile(new Binary(BsonBinarySubType.BINARY, voterFile.getBytes()));
	  doc.setSalaryFile(new Binary(BsonBinarySubType.BINARY, salaryFile.getBytes()));
	  doc.setLoaFile(new Binary(BsonBinarySubType.BINARY, loaFile.getBytes()));
	  doc.setNocFile(new Binary(BsonBinarySubType.BINARY, nocFile.getBytes()));
	  doc.setAgreementFile(new Binary(BsonBinarySubType.BINARY, agreementFile.getBytes()));
	
	  doc.setPanUrl(panUrl);
	  doc.setVoterUrl(voterUrl);
	  doc.setSalaryUrl(salaryUrl);
	  doc.setLoaUrl(loaUrl);
	  doc.setNocUrl(nocUrl);
	  doc.setAgreementUrl(agreementUrl);
	  doc.setEmail(email);
	  doc = dr.insert(doc); 
	  return doc.getId();
	  
  }
  
  public List<Documents> getDocumentsList()
  {
	  return dr.findAll();
  }
  
  public Documents getFile(String id) {
    return dr.findById(id).get();
  }
  
  public List<Documents> getDocuments(String email)
	 {
		 return (List<Documents>) dr.findByEmail(email);
	 }
  
  
}