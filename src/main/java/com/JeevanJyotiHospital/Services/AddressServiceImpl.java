package com.JeevanJyotiHospital.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JeevanJyotiHospital.Entities.Address;
import com.JeevanJyotiHospital.Repo.AddressRepo;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressRepo addressrepo;
	
	@Override
	public Address SaveAddress(Address address) {
		// TODO Auto-generated method stub
		return addressrepo.save(address);
	}
	

}
