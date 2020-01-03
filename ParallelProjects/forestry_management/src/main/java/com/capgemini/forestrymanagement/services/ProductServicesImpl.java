package com.capgemini.forestrymanagement.services;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.forestrymanagement.dao.ProductDao;
import com.capgemini.forestrymanagement.dto.Product;
import com.capgemini.forestrymanagement.factory.Factory;

public class ProductServicesImpl  implements ProductServices{

	ProductDao dao = Factory.getProductDaoImpl();
	@Override
	public boolean addProduct(Product p) {
		return dao.addProduct(p);
	}

	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		return dao.deleteProduct(productId);
	}

	@Override
	public boolean modifyProduct(int productId, String productName) {
		// TODO Auto-generated method stub
		return dao.modifyProduct(productId, productName);
	}

	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return dao.getProduct(productId);
	}

	@Override
	public ArrayList<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return dao.getAllProduct();
	}

}
