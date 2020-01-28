package com.capgemini.forestrymanagementspringrest.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestrymanagementspringrest.config.ORMConfig;
import com.capgemini.forestrymanagementspringrest.dto.Product;
import com.capgemini.forestrymanagementspringrest.testconfig.TestBeans;
@SpringJUnitConfig(classes = {TestBeans.class, ORMConfig.class})
class ProductServicesTest {

	@Autowired
	ProductServices productServices;
	
	@Test
	public void testAddProduct() {
		Product product = new Product();
		product.setProductId(786);
		product.setProductName("Wood");
		product.setQuantity("10Kg");
		assertTrue(productServices.addProduct(product));
		
	}

	@Test
	public void testDeleteProduct() {
		assertTrue(productServices.deleteProduct(786));
	}

	@Test
	public void testModifyProduct() {
		Product product = new Product();
		product.setProductId(786);
		product.setProductName("Wood");
		product.setQuantity("10Kg");
		productServices.addProduct(product);
		assertTrue(productServices.modifyProduct(product));
		productServices.deleteProduct(product.getProductId());
	}

	@Test
	public void testGetAllProduct() {
		assertNotNull(productServices.getAllProduct());
		
	}
	

}
