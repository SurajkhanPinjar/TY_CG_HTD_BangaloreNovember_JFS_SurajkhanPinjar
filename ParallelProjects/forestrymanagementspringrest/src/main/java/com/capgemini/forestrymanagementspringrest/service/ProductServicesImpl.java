package com.capgemini.forestrymanagementspringrest.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementspringrest.dao.ProductDao;
import com.capgemini.forestrymanagementspringrest.dto.Product;
import com.capgemini.forestrymanagementspringrest.exception.ProductExceptions;
import com.capgemini.forestrymanagementspringrest.validation.Validation;

@Service
public class ProductServicesImpl implements ProductServices {
	@Autowired
	private ProductDao productDao;

	@Override
	public boolean addProduct(Product product) {
		if (Validation.isStringOnlyAlphabet(product.getProductName())) {
			product.setProductName(product.getProductName());
		} else {
			throw new ProductExceptions("Enter Only Alphabates in Product Field");
		}
		
		return productDao.addProduct(product);
	}

	@Override
	public boolean deleteProduct(int productId) {
		return productDao.deleteProduct(productId);
	}

	@Override
	public boolean modifyProduct(Product product) {
		if (Validation.isStringOnlyAlphabet(product.getProductName())) {
			product.setProductName(product.getProductName());
		} else {
			throw new ProductExceptions("Enter Only Alphabates in Product Field");
		}
		
		return productDao.modifyProduct(product);
	}

	@Override
	public Product getProduct(int productId) {
		return productDao.getProduct(productId);
	}

	@Override
	public ArrayList<Product> getAllProduct() {
		return productDao.getAllProduct();
	}

}
