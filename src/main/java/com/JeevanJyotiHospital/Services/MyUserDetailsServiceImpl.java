package com.JeevanJyotiHospital.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.JeevanJyotiHospital.User;
import com.JeevanJyotiHospital.Entities.UserPrincipal;
import com.JeevanJyotiHospital.Repo.RegistrationRepo;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	RegistrationRepo regisrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = regisrepo.findByUsername(username);
		System.out.println(user);
		if (user == null) {
			System.out.println("User not Found");
			throw new UsernameNotFoundException("User not Found");
		}
		return new UserPrincipal(user);
	}

}
