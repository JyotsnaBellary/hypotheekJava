package com.wipro.velocity.hypotheek.model;



import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="documents")

public class Documents {

	@Id
	private String id;
	  private Binary panFile;
	  private Binary voterFile;
	  private Binary salaryFile;
	  private Binary loaFile;
	  private Binary nocFile;
	  private Binary agreementFile;
	  
	  private String panUrl;
	  private String voterUrl;
	  private String salaryUrl;
	  private String loaUrl;
	  private String nocUrl;
	  private String agreementUrl;
	  private String email;
	  
	public Documents() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Binary getPanFile() {
		return panFile;
	}
	public void setPanFile(Binary panFile) {
		this.panFile = panFile;
	}
	public Binary getVoterFile() {
		return voterFile;
	}
	public void setVoterFile(Binary voterFile) {
		this.voterFile = voterFile;
	}
	public Binary getSalaryFile() {
		return salaryFile;
	}
	public void setSalaryFile(Binary salaryFile) {
		this.salaryFile = salaryFile;
	}
	public Binary getLoaFile() {
		return loaFile;
	}
	public void setLoaFile(Binary loaFile) {
		this.loaFile = loaFile;
	}
	public Binary getNocFile() {
		return nocFile;
	}
	public void setNocFile(Binary nocFile) {
		this.nocFile = nocFile;
	}
	public Binary getAgreementFile() {
		return agreementFile;
	}
	public void setAgreementFile(Binary agreementFile) {
		this.agreementFile = agreementFile;
	}
	public String getPanUrl() {
		return panUrl;
	}
	public void setPanUrl(String panUrl) {
		this.panUrl = panUrl;
	}
	public String getVoterUrl() {
		return voterUrl;
	}
	public void setVoterUrl(String voterUrl) {
		this.voterUrl = voterUrl;
	}
	public String getSalaryUrl() {
		return salaryUrl;
	}
	public void setSalaryUrl(String salaryUrl) {
		this.salaryUrl = salaryUrl;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoaUrl() {
		return loaUrl;
	}
	public void setLoaUrl(String loaUrl) {
		this.loaUrl = loaUrl;
	}
	public String getNocUrl() {
		return nocUrl;
	}
	public void setNocUrl(String nocUrl) {
		this.nocUrl = nocUrl;
	}
	public String getAgreementUrl() {
		return agreementUrl;
	}
	public void setAgreementUrl(String agreementUrl) {
		this.agreementUrl = agreementUrl;
	}
	
	  
	}