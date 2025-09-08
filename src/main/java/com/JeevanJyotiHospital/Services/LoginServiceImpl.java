package com.JeevanJyotiHospital.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JeevanJyotiHospital.Entities.LoginUser;
import com.JeevanJyotiHospital.Repo.LoginRepo;
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepo loginrepo;



	@Override
	public LoginUser SaveLoginUser(LoginUser loginuser) {
		
		return	loginrepo.save(loginuser);
		 
	}



	@Override
	public LoginUser findUserByEmail(String email, String password) {
	LoginUser validuser=	loginrepo.findByEmail(email);
	
	if(validuser !=null && validuser.getPassword().equals(password)) {
		return validuser;
	}
		return null;
	}





}
