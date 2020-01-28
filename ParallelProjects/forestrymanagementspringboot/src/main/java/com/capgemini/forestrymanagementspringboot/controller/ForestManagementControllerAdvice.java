package com.capgemini.forestrymanagementspringboot.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.forestrymanagementspringboot.dto.AdminResponse;
import com.capgemini.forestrymanagementspringboot.dto.ContractsResponse;
import com.capgemini.forestrymanagementspringboot.dto.CustomerResponse;
import com.capgemini.forestrymanagementspringboot.dto.LandResponse;
import com.capgemini.forestrymanagementspringboot.dto.ProductResponse;
import com.capgemini.forestrymanagementspringboot.exception.AdminExceptions;
import com.capgemini.forestrymanagementspringboot.exception.ContractsExceptions;
import com.capgemini.forestrymanagementspringboot.exception.CustomerExceptions;
import com.capgemini.forestrymanagementspringboot.exception.LandExceptions;
import com.capgemini.forestrymanagementspringboot.exception.ProductExceptions;

@RestControllerAdvice
public class ForestManagementControllerAdvice {

	@ExceptionHandler(AdminExceptions.class)
	public AdminResponse handleAdminException(AdminExceptions e) {
		AdminResponse adminResponse = new AdminResponse();
		adminResponse.setStatusCode(501);
		adminResponse.setMessage("Exception");
		adminResponse.setDescription(e.getMessage());
		return adminResponse;
	}


	@ExceptionHandler(ContractsExceptions.class)
	public ContractsResponse handleContractsException(ContractsExceptions e) {
		ContractsResponse contractsResponse = new ContractsResponse();
		contractsResponse.setStatusCode(501);
		contractsResponse.setMessage("Exception");
		contractsResponse.setDescription(e.getMessage());
		return contractsResponse;
	}

	@ExceptionHandler(CustomerExceptions.class)
	public CustomerResponse handleCustomerException(CustomerExceptions e) {
		CustomerResponse customerResponse = new CustomerResponse();
		customerResponse.setStatusCode(501);
		customerResponse.setMessage("Exception");
		customerResponse.setDescription(e.getMessage());
		return customerResponse;
	}
	
	@ExceptionHandler(ProductExceptions.class)
	public ProductResponse handleProductException(ProductExceptions e) {
		ProductResponse productResponse = new ProductResponse();
		productResponse.setStatusCode(501);
		productResponse.setMessage("Exception");
		productResponse.setDescription(e.getMessage());
		return productResponse;
	}
	
 
	
	@ExceptionHandler(LandExceptions.class)
	public LandResponse handleLandException(LandExceptions e) {
		LandResponse landResponse = new LandResponse();
		landResponse.setStatusCode(501);
		landResponse.setMessage("Exception");
		landResponse.setDescription(e.getMessage());
		return landResponse;
	}
	
	

}
