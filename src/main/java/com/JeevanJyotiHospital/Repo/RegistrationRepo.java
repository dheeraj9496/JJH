package com.JeevanJyotiHospital.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JeevanJyotiHospital.User;
import java.util.List;


public interface RegistrationRepo extends JpaRepository<User, Long> {
	User  findByEmail(String email);

}
