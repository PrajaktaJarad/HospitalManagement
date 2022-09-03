package com.hospital.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.api.model.Appointment;
import com.hospital.api.model.Category;
import com.hospital.api.model.Doctor;
import com.hospital.api.repository.AppointmentRepository;
import com.hospital.api.repository.CategoryRepository;
import com.hospital.api.repository.DoctorRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class DoctorController {
 
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@PostMapping("/doctor/{cid}")
	public Doctor PostDoctor(@RequestBody Doctor doctor, @PathVariable("cid") Long cid) {
		Category category = categoryRepository.getById(cid);
		doctor.setCategory(category);
		return doctorRepository.save(doctor);	
	}
	
	@GetMapping("/doctor/{cid}")
	public List<Doctor> GetAllDoctors(@PathVariable("cid") Long cid) {
		return doctorRepository.findByCategoryId(cid);
	}
	
	@PostMapping("/appointment/{did}")
	public Appointment postAppointment(@PathVariable("did") Long did, @RequestBody Appointment appointment) {
		Doctor doctor = doctorRepository.getById(did);
		appointment.setDoctor(doctor);
		return appointmentRepository.save(appointment);
	}
	
	@GetMapping("/appointment/doctor/{did}")
	public List<Appointment> getAppointment(@PathVariable("did") Long did) {
		return appointmentRepository.findByDoctorId(did);
	}
}

