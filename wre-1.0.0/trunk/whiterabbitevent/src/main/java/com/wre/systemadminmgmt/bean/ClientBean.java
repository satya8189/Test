package com.wre.systemadminmgmt.bean;

public class ClientBean {
	
	private Long clientId;
    private String clientName;
    private String address;
    private String description;
    private String status;
    private Long userId;
    
    private String emailId;
    private String firstName;
    private String lastName;
    private String phoneNo;
    
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStaus(String status) {
		this.status = status;
	}
    
    

}
