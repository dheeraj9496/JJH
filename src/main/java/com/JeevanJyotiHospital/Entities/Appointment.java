package com.JeevanJyotiHospital.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Appointment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	public String name;
	public String email;
	public String Date;
	public Long phone;
	@ManyToOne(cascade=CascadeType.ALL)
	public Address address;
	
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", name=" + name + ", email=" + email + ", Date=" + Date + ", phone=" + phone
				+ ", address=" + address + "]";
		
	}
	
	public Appointment(Long id, String name, String email, String date, Long phone, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		Date = date;
		this.phone = phone;
		this.address = address;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	public Appointment() {
		super();
	}
	
}