package com.JeevanJyotiHospital;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.JeevanJyotiHospital.Entities.Appointment;
import com.JeevanJyotiHospital.Repo.RegistrationRepo;
import com.JeevanJyotiHospital.Services.RegistrationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HospitalController {

	@Autowired
	RegistrationService regiservice;

	@RequestMapping("/")
	public String home() {

		return "index";
	}

	@RequestMapping("private/register")
	public String bookings() {
		return "register";
	}

	@RequestMapping("/appointment")
	public String booking(Model m) {
		m.addAttribute("appointment", new Appointment());
		return "booking";
	}

	/*
	 * @RequestMapping("/regForm") public String output(HttpServletRequest request)
	 * { String uname=request.getParameter("username"); String
	 * email=request.getParameter("email"); String
	 * pass=request.getParameter("password");
	 * System.out.println("My name is  "+uname); System.out.println("My email is  "
	 * +email); System.out.println("My password is  " +pass); return null;
	 * 
	 * 
	 * }
	 */

	/*
	 * @RequestMapping("/regForm") public String output2(@RequestParam("username")
	 * String uname,
	 * 
	 * @RequestParam("email") String email,
	 * 
	 * @RequestParam("password") String password,
	 * 
	 * @RequestParam("phonenumber") String phone, Model model) {
	 * System.out.println(uname); System.out.println(email);
	 * System.out.println(password); System.out.println(phone);
	 * 
	 * model.addAttribute("username", uname); return "success";
	 * 
	 * }
	 */

	@RequestMapping("/regForm")
	public String registring_user(@ModelAttribute("user") User user, Model m) {
		final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
		user.setPassword(encoder.encode(user.getPassword()));
		this.regiservice.Saveuser(user);
		m.addAttribute("datetime", LocalDateTime.now().toString());
		System.out.println(user);
		if (user.username.isBlank()) {
			return "redirect:/book";
		}
		return "registrationsuccess";
	}

	@GetMapping("/ViewRegisteredUser")
	@ResponseBody
	public List<User> ViewRegisteredUser() {
		return regiservice.GetAllRegisteredUser();

	}

    //another way to view registered user
	@GetMapping("private/ViewAllRegisteredUser")

	public String ViewAllRegisteredUser(Model m) {
		m.addAttribute("datetime", LocalDateTime.now().toString());
		m.addAttribute("getallregistereduser", this.regiservice.GetAllRegisteredUser());
		m.addAttribute("Header1", "List of registered User");
		return "registereduser";

	}

	@ModelAttribute
	public void common(Model m) {
		m.addAttribute("Header", "Jeevan Jyoti Hospital");
		System.out.println("Common data added");

	}

	@RequestMapping("/service")
	public String service() {
		return "service";
	}

	@RequestMapping("/Contact")
	public String contact() {

		return "Contact";
	}

}
