package com.JeevanJyotiHospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.JeevanJyotiHospital")
public class JeevanJyotiHospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JeevanJyotiHospitalApplication.class, args);
		System.out.println("Hello , Your program Starts from Here!");
	}

}
