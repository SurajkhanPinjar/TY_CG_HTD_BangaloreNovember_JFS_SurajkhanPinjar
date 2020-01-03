package com.capgemini.forestry.services;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestry.bean.ProductBean;
import com.capgemini.forestry.dao.ProductDao;
import com.capgemini.forestry.factory.Factory;

public class ProductServicesImpl implements ProductServices{
	
	ProductDao dao = Factory.getProdDao();
	@Override
	public boolean addProduct(ProductBean bean) {
		return dao.addProduct(bean);
	}

	@Override
	public boolean deleteProduct(int productid) {
		return dao.deleteProduct(productid);
	}

	@Override
	public boolean modifyProduct(int productid, String productname) {
		// TODO Auto-generated method stub
		return dao.modifyProduct(productid, productname);
	}

	@Override
	public ArrayList<ProductBean> getProduct(int productid) {
		
		return dao.getProduct(productid);
	}

	@Override
	public ArrayList<ProductBean> getAllProduct() {
		// TODO Auto-generated method stub
		return dao.getAllProduct();
	}
	

}
