package com.capgemini.forestrymanagementspringboot.dao;

import java.util.ArrayList;

import com.capgemini.forestrymanagementspringboot.dto.Product;

public interface ProductDao {
	public boolean addProduct(Product p);

	public boolean deleteProduct(int productId);

	public boolean modifyProduct(Product product);

	public Product getProduct(int productId);

	public ArrayList<Product> getAllProduct();

}
