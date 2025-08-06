package com.JeevanJyotiHospital;

public class User {
	
	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", password=" + password + ", phonenumber="
				+ phonenumber + "]";
	}
	String username;
	String email;
	String password;
	Long phonenumber;
	
	

	public User(String username, String email, String password, Long phonenumber) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.phonenumber = phonenumber;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public Long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}
	
}
