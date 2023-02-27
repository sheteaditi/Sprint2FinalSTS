package com.nv.doctorapp.controller.appointment;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nv.doctorapp.dto.appointment.AppointmentResponseDTO;
import com.nv.doctorapp.entity.Appointment;
import com.nv.doctorapp.service.appointment.AppointmentService;
import com.nv.doctorapp.util.appointment.AppointmentDTOConverter;


@RestController
@RequestMapping("/appointment")
@CrossOrigin(origins = {"http://localhost:4200","htttp://localhost:8000"},allowedHeaders = "*")


public class AppointmentRestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AppointmentService appointmentService;

	@Autowired
	AppointmentDTOConverter dtoConvertor;

	public AppointmentRestController() {
		logger.info(" Doctor Rest Controller Called");
		System.err.println("-------Doctor Rest Controller Called-------");
	}

	@PostMapping("/register")
	public ResponseEntity<AppointmentResponseDTO> saveAppointment(@RequestBody Appointment appointment)
			throws Exception {

		Appointment savedAppointment = appointmentService.addAppointment(appointment);
		logger.info("Appointment Saved" + savedAppointment);

		AppointmentResponseDTO dto = dtoConvertor.convertTo(savedAppointment);

		return new ResponseEntity<AppointmentResponseDTO>(dto, HttpStatus.OK);

	}

	@GetMapping("/list")
	public ResponseEntity<List<AppointmentResponseDTO>> getAllAppointments() {

		List<Appointment> allAppointments = appointmentService.getAllAppointments();
		List<AppointmentResponseDTO> dtoList = new ArrayList<>();

		for (Appointment appointment : allAppointments) {

			AppointmentResponseDTO dtoObj = dtoConvertor.convertTo(appointment);
			dtoList.add(dtoObj);
		}
		return new ResponseEntity<List<AppointmentResponseDTO>>(dtoList, HttpStatus.OK);
	}

	@GetMapping("/getAppointmentById/{appointmentId}")
	public ResponseEntity<AppointmentResponseDTO> getAppointmentById(@PathVariable int appointmentId) {

		Appointment savedAppointment = appointmentService.getAppointmentById(appointmentId);
		AppointmentResponseDTO dto = dtoConvertor.convertTo(savedAppointment);
		return new ResponseEntity<AppointmentResponseDTO>(dto, HttpStatus.OK);
	}

	@DeleteMapping("/deleteAppointment/{appointmentId}")
	public void removeAppointment(@PathVariable int appointmentId) {
		appointmentService.removeAppointmentById(appointmentId);
	}
	
	@PutMapping("/{appointmenttId}")
	public String updatePatient(@PathVariable int patientId) {
		Appointment updatedAppointment = appointmentService.getAppointmentById(patientId);
		return updatedAppointment.toString();
	}
	
	@GetMapping("/byDate/{date}")
	public ResponseEntity<List<AppointmentResponseDTO>> getAppointmentByDate(@PathVariable String date) {

		List<Appointment> allAppointments = appointmentService.getAppointmentByDate(date);
		List<AppointmentResponseDTO> dtoList = new ArrayList<>();

		for (Appointment appointment : allAppointments) {

			AppointmentResponseDTO dtoObj = dtoConvertor.convertTo(appointment);
			dtoList.add(dtoObj);
		}
		return new ResponseEntity<List<AppointmentResponseDTO>>(dtoList, HttpStatus.OK);
	}
	
	@GetMapping("/byStatus/{status}")
	public ResponseEntity<List<AppointmentResponseDTO>> getAppointmentByStatus(@PathVariable String status) {

		List<Appointment> allAppointments = appointmentService.getAppointmentByStatus(status);
		List<AppointmentResponseDTO> dtoList = new ArrayList<>();

		for (Appointment appointment : allAppointments) {

			AppointmentResponseDTO dtoObj = dtoConvertor.convertTo(appointment);
			dtoList.add(dtoObj);
		}
		return new ResponseEntity<List<AppointmentResponseDTO>>(dtoList, HttpStatus.OK);
	}
	
//	@GetMapping("/byDoctor/{doctorName}")
//	public ResponseEntity<List<AppointmentResponseDTO>> getAppointmentByDoctor(@PathVariable String doctorName) {
//
//		List<Appointment> allAppointments = appointmentService.getAppointmentByDoctor(doctorName);
//		List<AppointmentResponseDTO> dtoList = new ArrayList<>();
//
//		for (Appointment appointment : allAppointments) {
//
//			AppointmentResponseDTO dtoObj = dtoConvertor.convertTo(appointment);
//			dtoList.add(dtoObj);
//		}
//		return new ResponseEntity<List<AppointmentResponseDTO>>(dtoList, HttpStatus.OK);
//	}
		
	
	@GetMapping("/patient/{patientName}")
	public ResponseEntity<List<AppointmentResponseDTO>> getAppointmentByPatient(@PathVariable String patientName){

		List<Appointment> allAppointments = appointmentService.getAppointmentByPatient(patientName);
		List<AppointmentResponseDTO> dtoList = new ArrayList<>();

		for (Appointment appointment : allAppointments) {

			AppointmentResponseDTO dtoObj = dtoConvertor.convertTo(appointment);
			dtoList.add(dtoObj);
		}
		return new ResponseEntity<List<AppointmentResponseDTO>>(dtoList, HttpStatus.OK);
	}

	

	
	
		
		

}
