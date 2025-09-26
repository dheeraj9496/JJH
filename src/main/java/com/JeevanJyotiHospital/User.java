package com.JeevanJyotiHospital;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class User {

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", password=" + password + ", phonenumber="
				+ phonenumber + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "username can not be null")

	public String username;
	@NotBlank(message = "Email can not be null")
	@Email
	public String email;
	@Column(length = -1)
	@Size(min = 5, max = 10, message = "password must be between 5 to 10 char")
	public String password;
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

	public User() {
		super();
	}

}
