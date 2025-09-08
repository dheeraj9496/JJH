package com.JeevanJyotiHospital.Controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;
import com.JeevanJyotiHospital.Services.LoginServiceImpl;
import com.JeevanJyotiHospital.Services.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
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

	m.addAttribute("login","Login Here!!");
	m.addAttribute("datetime",LocalDateTime.now().toString());
	m.addAttribute("user", new LoginUser());
		return "login";
	}
	
	
	@PostMapping("/logging")
	public String loggings(@Valid  @ModelAttribute("user") LoginUser user,BindingResult result,org.springframework.ui.Model m) {
	//	this.loginrepo.save(user);
		this.loginservice.SaveLoginUser(user);
		
		if(result.hasFieldErrors()) {
			System.out.println(result);
			return "login";
		}
		
		m.addAttribute("datetime",LocalDateTime.now().toString());
		System.out.println(user);
		
	/*	String userEmail = "dheeraj@gmail.com" ;
		String userPsw = "123456" ;
		if(user.email.equalsIgnoreCase(userEmail) && user.password.equals(userPsw))
		
			return "loginsuccess";
		else
			return "login" ;
		*/
	/*	
		
	LoginUser validuser=	loginservice.findUserByEmail(user.email, user.password);
	if(validuser !=null)
		return "loginsuccess";
	
	else
		return "login";
	*/
		
		
	User validregistereduser=regisservice.finduserByEmail(user.email, user.password);
	if(validregistereduser !=null) {
		m.addAttribute("username", validregistereduser.getUsername());
	 return "loginsuccess";
	}
	else {
		m.addAttribute("errormsg", "Username or password did not match");
        return "login";
	}
	}
	
	@GetMapping("/logouts")
	
	public String logout(org.springframework.ui.Model m) {
		
		return "redirect:/logins";
	}
			
	
}

