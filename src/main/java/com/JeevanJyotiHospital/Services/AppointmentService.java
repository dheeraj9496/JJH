package com.JeevanJyotiHospital.Services;

import java.util.List;

import com.JeevanJyotiHospital.Entities.Appointment;

public interface AppointmentService {
	
	List<Appointment> GetAllAppointment();
	Appointment BookAppointment(Appointment appointment);
}
