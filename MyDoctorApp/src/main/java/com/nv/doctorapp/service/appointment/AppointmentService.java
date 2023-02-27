package com.nv.doctorapp.service.appointment;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nv.doctorapp.entity.Appointment;



@Service
public interface AppointmentService {
	
	
	

	public List<Appointment> getAllAppointments();
	
	public Appointment getAppointmentById(int appointmentId);
	
	public Appointment addAppointment(Appointment appointment) throws Exception;
	
	public void removeAppointmentById(int appointmentId);
	
	public Appointment updateAppointmentById(int appointmentId);
	
	public List<Appointment> getAppointmentByStatus(String status);
	
	public List<Appointment> getAppointmentByDate(String date);
	
	//public List<Appointment> getAppointmentByDoctor(String doctorName);
	
	public List<Appointment> getAppointmentByPatient(String patientName);
	
	
	
	
	
	
	
	
	

}
 