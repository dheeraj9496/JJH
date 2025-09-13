package com.JeevanJyotiHospital.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JeevanJyotiHospital.User;

@Repository
public interface RegistrationRepo extends JpaRepository<User, Long> {
	User  findByEmail(String email);

	User findByUsername(String username);
	

}
