package com.capgemini.forestrymanagementspringrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.forestrymanagementspringrest.dto.AdminResponse;
import com.capgemini.forestrymanagementspringrest.dto.ContractsResponse;
import com.capgemini.forestrymanagementspringrest.dto.CustomerResponse;
import com.capgemini.forestrymanagementspringrest.dto.LandResponse;
import com.capgemini.forestrymanagementspringrest.dto.ProductResponse;
import com.capgemini.forestrymanagementspringrest.exception.AdminExceptions;
import com.capgemini.forestrymanagementspringrest.exception.ContractsExceptions;
import com.capgemini.forestrymanagementspringrest.exception.CustomerExceptions;
import com.capgemini.forestrymanagementspringrest.exception.LandExceptions;
import com.capgemini.forestrymanagementspringrest.exception.ProductExceptions;

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
