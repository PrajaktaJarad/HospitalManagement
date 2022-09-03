package com.hospital.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.api.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
	List<Appointment> findByDoctorId(Long did);

}
