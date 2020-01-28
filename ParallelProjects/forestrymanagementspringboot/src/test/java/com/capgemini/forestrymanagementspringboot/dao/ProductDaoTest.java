package com.capgemini.forestrymanagementspringboot.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestrymanagementspringboot.dto.Product;

@SpringBootTest
class ProductDaoTest {
	@Autowired
	ProductDao productDao;
	
	@Test
	public void testAddProduct() {
		Product product = new Product();
		product.setProductId(786);
		product.setProductName("Wood");
		product.setQuantity("10Kg");
		assertTrue(productDao.addProduct(product));
		
	}

	@Test
	public void testDeleteProduct() {
		assertTrue(productDao.deleteProduct(786));
	}

	@Test
	public void testModifyProduct() {
		Product product = new Product();
		product.setProductId(786);
		product.setProductName("Wood");
		product.setQuantity("10Kg");
		productDao.addProduct(product);
		assertTrue(productDao.modifyProduct(product));
		productDao.deleteProduct(product.getProductId());
	}

	@Test
	public void testGetAllProduct() {
		assertNotNull(productDao.getAllProduct());
		
	}

}
