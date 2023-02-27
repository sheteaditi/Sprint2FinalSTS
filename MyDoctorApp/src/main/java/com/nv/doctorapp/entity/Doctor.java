//package com.nv.doctorapp.entity;
//
//import jakarta.persistence.Embedded;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//public class Doctor {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int doctorId;
//	private String doctorName;
//	private String speciality;
//	private String location;
//	private String email;
//	private double chargePerVisit;
//
//	@Embedded
//	private AvailabilityDates availabilityDates;
//
//	public Doctor(String doctorName, String speciality, String location, String email, double chargePerVisit) {
//		super();
//		this.doctorName = doctorName;
//		this.speciality = speciality;
//		this.location = location;
//		this.email = email;
//		this.chargePerVisit = chargePerVisit;
//	}
//
//	public Doctor(String doctorName, String speciality, String location, String hospitalName, String email,
//			double chargePerVisit, AvailabilityDates availabilityDates) {
//		super();
//		this.doctorName = doctorName;
//		this.speciality = speciality;
//		this.location = location;
//		this.email = email;
//		this.chargePerVisit = chargePerVisit;
//		this.availabilityDates = availabilityDates;
//	}
//
//	public Object getDoctorName() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public Object getEmail() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public Object getAvailabilityDates() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public String getSpeciality() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public double getChargePerVisit() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	
//
//
//}
