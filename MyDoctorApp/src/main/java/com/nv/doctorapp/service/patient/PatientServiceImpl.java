package com.nv.doctorapp.service.patient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nv.doctorapp.entity.Appointment;
import com.nv.doctorapp.entity.Patient;
import com.nv.doctorapp.exception.patient.InvalidPatientException;
import com.nv.doctorapp.repository.appointment.AppointmentRepository;
import com.nv.doctorapp.repository.patient.IPatientRepository;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private IPatientRepository patientRepository;
	
	/*@Autowired
	private AppointmentRepository appointmentRepository;*/

	@Override
	public Patient registerPatient(Patient patient) throws Exception {

		if (patient.getPatientName().equals("")) {
			throw new InvalidPatientException("Invalid Patient Name");
		}

		if (patient.getPatientCity().equals("")) {
			throw new InvalidPatientException("Invalid City");
		}

		else
			return patientRepository.save(patient);

	}

	@Override
	public Patient updatepatientDetailsById(int patientId) {

		Patient updatedPatient = patientRepository.getReferenceById(patientId);
		patientRepository.save(updatedPatient);
		return updatedPatient;
	}

	@Override
	public void removePatientDetailsById(int patientId) {

		patientRepository.deleteById(patientId);
	}

	@Override
	public List<Patient> getAllPatients() {

		return patientRepository.findAll();
	}

	@Override
	public Patient getPatientById(int patientId) {

		return patientRepository.getReferenceById(patientId);
	}

	@Override
	public List<Patient> getPatientByCity(String patientCity) {

		List<Patient> allPatients = patientRepository.findAll();
		List<Patient> requiredPatients = new ArrayList<>();
		for (Patient obj : allPatients) {
			if (obj.getPatientCity().equalsIgnoreCase(patientCity)) {
				requiredPatients.add(obj);
			}
		}
		return requiredPatients;

	}

	@Override
	public List<Patient> getPatientByName(String patientName) {

		List<Patient> allPatients = patientRepository.findAll();
		List<Patient> requiredPatients = new ArrayList<>();
		for (Patient obj : allPatients) {
			if (obj.getPatientName().equalsIgnoreCase(patientName)) {
				requiredPatients.add(obj);
			}
		}
		return requiredPatients;

	}

	/*
	 * @Override public List<Patient> getPatientByAge(int patientAge) {
	 * 
	 * List<Patient> allPatients = patientRepository.findAll(); List<Patient>
	 * requiredPatients = new ArrayList<>(); for (Patient obj : allPatients) { if
	 * (obj.getPatientAge(patientAge)) { requiredPatients.add(obj); } } return
	 * requiredPatients; }
	 */

	@Override
	public List<Patient> getPatientByGender(String patientGender) {

		List<Patient> allPatients = patientRepository.findAll();
		List<Patient> requiredPatients = new ArrayList<>();
		for (Patient obj : allPatients) {
			if (obj.getPatientGender().equalsIgnoreCase(patientGender)) {
				requiredPatients.add(obj);
			}
		}
		return requiredPatients;
	}

	@Override
	public List<Patient> getPatientByDisease(String patientDisease) {

		List<Patient> allPatients = patientRepository.findAll();
		List<Patient> requiredPatients = new ArrayList<>();
		for (Patient obj : allPatients) {
			if (obj.getPatientDisease().equalsIgnoreCase(patientDisease)) {
				requiredPatients.add(obj);
			}
		}
		return requiredPatients;
	}

	@Override
	public List<Patient> getPatientByAge(int patientAge) {

		List<Patient> allPatients = patientRepository.findAll();
		List<Patient> requiredPatients = new ArrayList<>();
		for (Patient obj : allPatients) {
			if (obj.getPatientAge() == (patientAge)) {
				requiredPatients.add(obj);
			}
		}
		return requiredPatients;
	}

	/*@Override
	public Patient updateAppointmentByPatientId(int patientId, int appointmentId) {
		
		Patient patientFromDB = getPatientById(patientId);
		Appointment appointmentFromDB = appointmentRepository.getReferenceById(appointmentId);
		
		if(patientFromDB !=null & appointmentFromDB != null) {
			List<Patient> allPatients = appointmentFromDB.getPatient();
			
			if(allPatients!= null && allPatients.isEmpty()==false) {
				allPatients.add(patientFromDB);
				appointmentFromDB.setPatient(allPatients);
			}
			else {
				List<Patient> newPatientList=new ArrayList<>();
				newPatientList.add(patientFromDB);
				appointmentFromDB.setPatient(newPatientList);
			}
			appointmentRepository.saveAndFlush(appointmentFromDB);
			patientRepository.save(patientFromDB);
			return patientFromDB;
		}
		else {
			return null;
		}*/
	}

