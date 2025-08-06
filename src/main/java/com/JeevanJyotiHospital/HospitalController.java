package com.JeevanJyotiHospital;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HospitalController {
	
	@RequestMapping("/")
	public String home() {
		
		return "index";
	}
		
	
@RequestMapping("/book")
public String bookings() {
	return "booking";
}


/*
 * @RequestMapping("/regForm")
 *  public String output(HttpServletRequest request)
 * {
 *  String uname=request.getParameter("username"); 
 *  String email=request.getParameter("email"); 
 *  String pass=request.getParameter("password");
 * System.out.println("My name is  "+uname);
 *  System.out.println("My email is  " +email); 
 *  System.out.println("My password is  " +pass); 
 *  return null;
 * 
 * 
 * }
 */
  
  
 /* @RequestMapping("/regForm")
  public String output2(@RequestParam("username") String uname, 
		  @RequestParam("email") String email,
		  @RequestParam("password") String password,
		  @RequestParam("phonenumber") String phone,
		  Model model) {
	  System.out.println(uname);
	  System.out.println(email);
	  System.out.println(password);
	  System.out.println(phone);
	  
	  model.addAttribute("username", uname);
	return "success";
	  
  }
 */

@RequestMapping("/regForm")
public String output3(@ModelAttribute User user) {
	

	System.out.println(user);
	if (user.username.isBlank())
	{
		return "redirect:/book";
	}





	return "success";
}
  
  
  
  @ModelAttribute
  public void common(Model m) {
	  m.addAttribute("Header","Jeevan Jyoti Hospital");
	  System.out.println("Common data added");
	  
  }
  

 
}
