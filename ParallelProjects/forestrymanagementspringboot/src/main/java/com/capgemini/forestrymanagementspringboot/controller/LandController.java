package com.capgemini.forestrymanagementspringboot.controller;

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

import com.capgemini.forestrymanagementspringboot.dto.Land;
import com.capgemini.forestrymanagementspringboot.dto.LandResponse;
import com.capgemini.forestrymanagementspringboot.service.LandServices;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class LandController {

	@Autowired
	private LandServices landServices ;
	
	@PostMapping(path = "/add-land", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LandResponse addLand(@RequestBody Land land) {
		LandResponse landResponse = new LandResponse();
		if (landServices.addLand(land)) {
			landResponse.setStatusCode(201);
			landResponse.setMessage("Success");
			landResponse.setDescription("Land Added Successfully");
		}
		return landResponse;
	}
	
	@DeleteMapping(path = "/delete-land/{landId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public LandResponse deleteCustomer(@PathVariable("landId") int landId) {
		LandResponse landResponse = new LandResponse();
		if (landServices.deleteLand(landId)) {
			landResponse.setStatusCode(201);
			landResponse.setMessage("Success");
			landResponse.setDescription("Land Details Deleted Successfully");
		}
		return landResponse;
	}
	
	@GetMapping(path = "/get-all-land", produces = MediaType.APPLICATION_JSON_VALUE)
	public LandResponse getAllLand() {
		LandResponse landResponse = new LandResponse();
		List<Land> list = landServices.getAllLand();
		if (list.size()!=0) {
			landResponse.setStatusCode(201);
			landResponse.setMessage("Success");
			landResponse.setDescription("Land Found Successfully");
			landResponse.setLandResponse(list);
			return landResponse;
		}
		return landResponse;
	}
	
	@PutMapping(path = "/modify-Land", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LandResponse modifyLand(@RequestBody Land land) {
		LandResponse landResponse = new LandResponse();
		if (landServices.modifyLand(land)) {
			landResponse.setStatusCode(201);
			landResponse.setMessage("Success");
			landResponse.setDescription("Land Modified Successfully");
		}
		return landResponse;
	}
	

}
