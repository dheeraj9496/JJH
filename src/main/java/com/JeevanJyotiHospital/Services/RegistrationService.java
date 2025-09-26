package com.JeevanJyotiHospital.Services;

import java.util.List;

import com.JeevanJyotiHospital.User;

public interface RegistrationService {
	List<User> GetAllRegisteredUser();
	User Saveuser(User user);
	User finduserByEmail(String email,String password);
	User findUserByUsername(String username,String password);
	

}
