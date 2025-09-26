package com.JeevanJyotiHospital.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.JeevanJyotiHospital.User;
import com.JeevanJyotiHospital.Repo.RegistrationRepo;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	RegistrationRepo regisrepo;

	@Override
	public List<User> GetAllRegisteredUser() {

		return (List<User>) regisrepo.findAll();
	}

	@Override
	public User Saveuser(User user) {
		
		final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
		user.setPassword(encoder.encode(user.getPassword()));
		return regisrepo.save(user);
	}

	@Override
	public User finduserByEmail(String email, String password) {
		User validregistereduser = regisrepo.findByEmail(email) ;

		if (validregistereduser != null && validregistereduser.getPassword().equals(password)) {
			return validregistereduser;
			
		}
		
		return null;
	}

	@Override
	public User findUserByUsername(String username, String password) {
		
	User	validregistereduser1=regisrepo.findByUsername(username);
	if(validregistereduser1 != null && validregistereduser1.getPassword().equals(password)) {
		return validregistereduser1;
	}
		return null;
	}

}
