package com.capgemini.healthcare.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcare.dto.Appointment;
import com.capgemini.healthcare.dto.DiagnosticCenter;
import com.capgemini.healthcare.dto.Test;
import com.capgemini.healthcare.dto.User;
import com.capgemini.healthcare.response.AppointmentResponse;
import com.capgemini.healthcare.response.DiagnosticCenterResponse;
import com.capgemini.healthcare.response.TestResponse;
import com.capgemini.healthcare.response.UserResponse;
import com.capgemini.healthcare.service.AppointmentService;
import com.capgemini.healthcare.service.DiagnosticCenterService;
import com.capgemini.healthcare.service.TestService;
import com.capgemini.healthcare.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class AdminController {

	@Autowired
	UserService userService;

	@Autowired
	DiagnosticCenterService diagnosticCenterService;
	
	@Autowired
	TestService testService;
	
	@Autowired
	AppointmentService appointmentService;

	@PostMapping(path = "/login-user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse login(@RequestBody User user) {
		UserResponse userResponse = new UserResponse();
		User userAccount = userService.loginUser(user);
		if (userAccount != null) {
			userResponse.setStatusCode(201);
			userResponse.setDescription("Success");
			userResponse.setMessage("User Logged in Successfully");
			userResponse.setUser(Arrays.asList(userAccount));
		}
		return userResponse;
	}

	@PostMapping(path = "/add-center", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticCenterResponse addUser(@RequestBody DiagnosticCenter diagnosticCenter) {
		DiagnosticCenterResponse diagnosticCenterResponse = new DiagnosticCenterResponse();
		if (diagnosticCenterService.addCenter(diagnosticCenter)) {
			diagnosticCenterResponse.setStatusCode(201);
			diagnosticCenterResponse.setMessage("Success");
			diagnosticCenterResponse.setDescription("Center Added Successfully");
		}
		return diagnosticCenterResponse;
	}
	
	@PutMapping(path = "/update-center", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticCenterResponse updateCenter(@RequestBody DiagnosticCenter center) {
		DiagnosticCenterResponse diagnosticCenterResponse = new DiagnosticCenterResponse();
		if (diagnosticCenterService.updateCenter(center)) {
			diagnosticCenterResponse.setStatusCode(201);
			diagnosticCenterResponse.setMessage("Success");
			diagnosticCenterResponse.setDescription("Center Name Modified Successfully");
		}
		return diagnosticCenterResponse;
	}
	
	@DeleteMapping(path = "/delete-center/{centerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticCenterResponse deleteCenter(@PathVariable("centerId") String centerId) {
		DiagnosticCenterResponse diagnosticCenterResponse = new DiagnosticCenterResponse();
		if (diagnosticCenterService.removeCenter(centerId)) {
			diagnosticCenterResponse.setStatusCode(201);
			diagnosticCenterResponse.setMessage("Success");
			diagnosticCenterResponse.setDescription("Center Deleted Successfully");
		}
		return diagnosticCenterResponse;
	}
	
	@GetMapping(path = "/search-center/{centerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticCenterResponse searchCenter(@PathVariable("centerId") String centerId) {
		DiagnosticCenterResponse diagnosticCenterResponse = new DiagnosticCenterResponse();
		DiagnosticCenter center = diagnosticCenterService.searchCenter(centerId);
		if (center != null) {
			diagnosticCenterResponse.setStatusCode(201);
			diagnosticCenterResponse.setMessage("Success");
			diagnosticCenterResponse.setDescription("Center Found Successfully");
			diagnosticCenterResponse.setDiagnosticCenter(Arrays.asList(center));
		}
		return diagnosticCenterResponse;
	}
	
	@GetMapping(path = "/get-all-center", produces = MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticCenterResponse getAllCenter() {
		DiagnosticCenterResponse diagnosticCenterResponse = new DiagnosticCenterResponse();
		List<DiagnosticCenter> centerList = diagnosticCenterService.getAllCenter();
		if (centerList.size() != 0) {
			diagnosticCenterResponse.setStatusCode(201);
			diagnosticCenterResponse.setMessage("Success");
			diagnosticCenterResponse.setDescription("Center Found Successfully");
			diagnosticCenterResponse.setDiagnosticCenter(centerList);
			return diagnosticCenterResponse;
		}
		return diagnosticCenterResponse;
	}
	
	
	//----------------------------------TEST Controller--------------------------------
	
	@PostMapping(path = "/add-test", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public TestResponse addTest(@RequestBody Test test) {
		TestResponse testResponse = new TestResponse();
		if (testService.addTest(test)) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("Success");
			testResponse.setDescription("Test Added Successfully");
		}
		return testResponse;
	}
	
	@PutMapping(path = "/update-test", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public TestResponse updateTest(@RequestBody Test test) {
		TestResponse testResponse = new TestResponse();
		if (testService.updateTest(test)) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("Success");
			testResponse.setDescription("Test Name Modified Successfully");
		}
		return testResponse;
	}
	
	@DeleteMapping(path = "/delete-test/{centerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public TestResponse deleteTest(@PathVariable String centerId) {
		TestResponse testResponse = new TestResponse();
		if (testService.removeTest(centerId)) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("Success");
			testResponse.setDescription("Test Deleted Successfully");
		}
		return testResponse;
	}
	
	@GetMapping(path = "/search-test/{testId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public TestResponse searchtest(@PathVariable("testId") int testId) {
		TestResponse testResponse = new TestResponse();
		Test test = testService.searchTest(testId);
		if (test != null) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("Success");
			testResponse.setDescription("Test Found Successfully");
			testResponse.setTest(Arrays.asList(test));
		}
		return testResponse;
	}
	
	@GetMapping(path = "/get-all-test", produces = MediaType.APPLICATION_JSON_VALUE)
	public TestResponse getAllTest() {
		TestResponse testResponse = new TestResponse();
		List<Test> testList = testService.getAllTest();
		if (testList.size() != 0) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("Success");
			testResponse.setDescription("Test Found Successfully");
			testResponse.setTest(testList);
			return testResponse;
		}
		return testResponse;
	}
	
	@GetMapping(path = "/get-all-test-center/{centerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public TestResponse getAllTestCenter(@PathVariable("centerId") String centerId) {
		TestResponse testResponse = new TestResponse();
		List<Test> testList = testService.getAllTestCenter(centerId);
		if (testList.size() != 0) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("Success");
			testResponse.setDescription("Test Found Successfully");
			testResponse.setTest(testList);
			return testResponse;
		}
		return testResponse;
	}
	
	/* ------------------------------Appointment---------------------------- */
	
	@PutMapping(path = "/approve-appointment",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse approveAppointment(@RequestBody Appointment appointment) {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		if (appointmentService.approveAppointment(appointment)) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription("Appointment Approved Successfully");
		}
		return appointmentResponse;
	}
	
	
	@GetMapping(path = "/get-all-appointment", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse getAllAppointment() {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		List<Appointment> appointmentList = appointmentService.getAllAppointment();
		if (appointmentList.size() != 0) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription("Appointments Found Successfully");
			appointmentResponse.setAppointment(appointmentList);
			return appointmentResponse;
		}
		return appointmentResponse;
	}
	
	
	
	
	
}
