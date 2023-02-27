package com.nv.doctorapp.dto.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponseDTO {
	
	
	
	private int appointmentId;
	private String date;
	private String status;
	
	private String patientName;
	private String patientCity;
	private int patientAge;
	private String patientGender;
	private String patientDisease;
	private String patientPhoneNumber;
	private String patientBloodGroup;
	
	private String doctorName;
	private String hospitalName;
	private String speciality;
	

}
