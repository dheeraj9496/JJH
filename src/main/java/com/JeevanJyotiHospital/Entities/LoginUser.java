package com.JeevanJyotiHospital.Entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LoginUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Uid;
	@Email
	@NotBlank(message="Email can not be null")
	public String email;
	
	@NotBlank(message="password can not be null")
	@Size(min=5, max=10, message="password must be between 5 to 10 char")
	public String password;
	
	public Long getUid() {
		return Uid;
	}
	public void setUid(Long uid) {
		Uid = uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginUser [email=" + email + ", password=" + password + "]";
	}
	public LoginUser(Long uid, String email, String password) {
		super();
		Uid = uid;
		this.email = email;
		this.password = password;
	}
	public LoginUser() {
		super();
	}
	
	
	

}
