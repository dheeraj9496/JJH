package com.JeevanJyotiHospital.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JeevanJyotiHospital.User;
import com.JeevanJyotiHospital.Repo.RegistrationRepo;

@Service
public class RegistrationServiceImpl implements RegistrationService{
	
	@Autowired
	RegistrationRepo regisrepo;
	


	@Override
	public List<User> GetAllRegisteredUser() {
		
		return (List<User>) regisrepo.findAll();
	}

	@Override
	public User Saveuser(User user) {
		
		return regisrepo.save(user);
	}

	@Override
	public User finduserByEmail(String email, String password) {
	User	validregistereduser= regisrepo.findByEmail(email);
	
	
	if(validregistereduser !=null && validregistereduser.getPassword().equals(password)) {
		return validregistereduser;
	}
		return null;
	}
	
	

}
