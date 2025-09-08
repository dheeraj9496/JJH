package com.JeevanJyotiHospital.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.JeevanJyotiHospital.Entities.LoginUser;
import java.util.List;


public interface LoginRepo extends JpaRepository<LoginUser, Long> {

	
	public LoginUser   findByEmail(String email);
	

}
