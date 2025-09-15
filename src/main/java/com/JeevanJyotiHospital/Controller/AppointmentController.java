package com.JeevanJyotiHospital.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.JeevanJyotiHospital.Entities.Address;
import com.JeevanJyotiHospital.Entities.Appointment;
import com.JeevanJyotiHospital.Services.AddressService;
import com.JeevanJyotiHospital.Services.AppointmentService;

@Controller
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentservice;
	@Autowired
	AddressService addressservice;
	
	@PostMapping("/booked")
	public String booking(@ModelAttribute("appointment") Appointment appointments,@ModelAttribute("address") Address address,Model m) {
		m.addAttribute("datetime",LocalDateTime.now().toString());
		System.out.println(appointments);
		System.out.println(address);
		this.addressservice.SaveAddress(address);
		this.appointmentservice.BookAppointment(appointments);
		return "appointmentsuccess";
		
	}
	
	
	@GetMapping("private/ViewAppointment")
	//@ResponseBody
	public String Viewappointment(Model m) {
	//	return this.appointmentservice.GetAllAppointment();
		m.addAttribute("viewappointment",  this.appointmentservice.GetAllAppointment());
		m.addAttribute("datetime",LocalDateTime.now().toString());
		m.addAttribute("Header", "List of appointment");
	
		return "viewappointment";

		
	}

}
