package com.JeevanJyotiHospital.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long addId;
	public String area;
	public String city;
	public String state;
	public Long pincode;
	public Long getAddId() {
		return addId;
	}
	public void setAddId(Long addId) {
		this.addId = addId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	public Address(Long addId, String area, String city, String state, Long pincode) {
		super();
		this.addId = addId;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [addId=" + addId + ", area=" + area + ", city=" + city + ", state=" + state + ", pincode="
				+ pincode + "]";
	}
	
	public Address() {
		super();
	}
}
