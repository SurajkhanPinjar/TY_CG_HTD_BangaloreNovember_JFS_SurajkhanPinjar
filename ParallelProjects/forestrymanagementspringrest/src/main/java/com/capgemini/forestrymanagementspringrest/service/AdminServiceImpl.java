package com.capgemini.forestrymanagementspringrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementspringrest.dao.AdminDao;
import com.capgemini.forestrymanagementspringrest.dto.Admin;
import com.capgemini.forestrymanagementspringrest.exception.AdminExceptions;
import com.capgemini.forestrymanagementspringrest.validation.Validation;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao ;
	
//	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Override
	public boolean addAdmin(Admin admin) {
//		String encodePassword = encoder.encode(admin.getAdminPassword());
//		admin.setAdminPassword(encodePassword);
		if (Validation.isStringOnlyAlphabet(admin.getAdminName())) {
			admin.setAdminName(admin.getAdminName());
		} else {
			throw new AdminExceptions("Enter Only Alphabates in Name Field..");
		}
		
		if (Validation.calculatePasswordStrength(admin.getAdminPassword()) >= 8) {
			admin.setAdminPassword(admin.getAdminPassword());
		} else {
			throw new AdminExceptions("Enter Minimum 8 characters, atleast 1 lowercase,1 Upper Case, 1 Special Case"
					+ " and atleast 1 integer in Password Field ");
		}
	
			String email = admin.getAdminEmail();
			if (Validation.isValidEmail(email)) {
				admin.setAdminEmail(email);
			} else {
				throw new AdminExceptions("Enter Valid Email Id in Email Field(i.e. abc@g.com).");
			}
			return adminDao.addAdmin(admin);

	}
	@Override
	public Admin login(Admin admin) {
		return adminDao.login(admin);
	}

	@Override
	public boolean deleteAdmin(String adminName) {
		return adminDao.deleteAdmin(adminName);
	}

	

	

}
