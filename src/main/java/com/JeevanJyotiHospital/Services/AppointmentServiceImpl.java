package com.JeevanJyotiHospital.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.JeevanJyotiHospital.Entities.Appointment;
import com.JeevanJyotiHospital.Repo.AppointmentRepo;
@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentRepo appointrepo;
	

	
	@Override
	public List<Appointment> GetAllAppointment() {
		// TODO Auto-generated method stub
		return (List<Appointment>) appointrepo.findAll();
	}

	@Override
	public Appointment BookAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return appointrepo.save(appointment);
	}


	
}
