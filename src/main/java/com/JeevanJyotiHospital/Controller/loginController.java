package com.JeevanJyotiHospital.Controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;
import com.JeevanJyotiHospital.Services.LoginServiceImpl;
import com.JeevanJyotiHospital.Services.RegistrationService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.JeevanJyotiHospital.User;
import com.JeevanJyotiHospital.Entities.LoginUser;
import com.JeevanJyotiHospital.Repo.LoginRepo;
import com.JeevanJyotiHospital.Services.AppointmentService;
import com.JeevanJyotiHospital.Services.LoginService;

@Controller
public class loginController {

	@Autowired
	AppointmentService appointservice;

	@Autowired
	LoginRepo loginrepo;

	@Autowired
	RegistrationService regisservice;

	@Autowired
	LoginService loginservice;

	@RequestMapping("/logins")
	public String login(org.springframework.ui.Model m) {

		m.addAttribute("login", "Login Here!!");
		m.addAttribute("datetime", LocalDateTime.now().toString());
		m.addAttribute("user", new LoginUser());
		return "login";
	}

	@PostMapping("/logging")
	public String loggings(@ModelAttribute("loginuser") LoginUser loginuser, org.springframework.ui.Model m,
			@ModelAttribute("user") User user) {

		final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
		loginuser.setPassword(encoder.encode(loginuser.getPassword()));
		this.loginservice.SaveLoginUser(loginuser);
		m.addAttribute("datetime", LocalDateTime.now().toString());
		System.out.println(loginuser);

		/*
		 * String userEmail = "dheeraj@gmail.com" ; String userPsw = "123456" ;
		 * if(user1.email.equalsIgnoreCase(userEmail) && user1.password.equals(userPsw))
		 * 
		 * return "loginsuccess"; else return "login" ;
		 */

		User validregistereduser = regisservice.finduserByEmail(user.email, user.password);
		System.out.println(user);
		if (validregistereduser != null) {
			m.addAttribute("username", validregistereduser.getUsername());
			return "loginsuccess";
		} else {
			m.addAttribute("errormsg", "Username or password did not match");
			return "login";
		}
	}

	@GetMapping("/logouts")

	public String logout(org.springframework.ui.Model m) {

		return "redirect:/logins";
	}

}
