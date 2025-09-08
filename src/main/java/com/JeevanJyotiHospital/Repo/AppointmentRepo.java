package com.JeevanJyotiHospital.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JeevanJyotiHospital.Entities.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

}
