package com.capgemini.springrest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springrest.dto.EmployeeBean;
import com.capgemini.springrest.dto.EmployeeResponse;
import com.capgemini.springrest.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	
	@PostMapping(path = "/auth", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse auth(@RequestBody EmployeeBean bean) {
		 EmployeeBean employeeBean = service.auth(bean.getEmail(), bean.getPassword());
		 EmployeeResponse response = new EmployeeResponse();
		 if (employeeBean != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDiscription("Employee Found for the Credentials");
			response.setBeans(Arrays.asList(employeeBean));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDiscription("Credentials Invalid");
		}
		 return response;
	}
	
	@PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse register(@RequestBody EmployeeBean bean ) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.register(bean)) {
			response.setStatusCode(201);
			response.setMessage("Succes");
			response.setDiscription("Employee Registered");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDiscription("Email Already Exists ");
		}
		return response;
		
	}
	
	
	@GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse searchEmployee(@RequestParam("key") String key) {
		EmployeeResponse response = new EmployeeResponse();
		List<EmployeeBean> list = service.getEmployee(key);
		if (!list.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDiscription("Employee Data Found");
			response.setBeans(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDiscription("Not Found ");
		}
		return response;
		
	}
	
	 
	@PutMapping(path = "/change-password", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse changePassword(@RequestBody EmployeeBean bean) {		
		EmployeeResponse response = new EmployeeResponse();
		if (service.changePassword(bean.getEid(), bean.getPassword())) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDiscription("Password Changed");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDiscription("Password Not Changed ");
		}
		return response;
	}
	
	@DeleteMapping(path = "/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
	public EmployeeResponse deleteEmployee(@PathVariable("id") int id) {
		EmployeeResponse response = new EmployeeResponse();
		service.deleteEmp(id); 
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDiscription("Employee Details Deleted");
		
		return response;
	}
	

}
