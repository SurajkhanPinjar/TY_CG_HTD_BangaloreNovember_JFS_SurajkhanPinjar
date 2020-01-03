package com.capgemini.forestmanagement.dao;

import java.util.List;

import com.capgemini.forestmanagement.bean.ProductBean;

public interface ProductDao {
	public boolean addProduct(ProductBean bean);
	public boolean deleteProduct(int prodid);
	public boolean modifyProduct(int prodid);
	public boolean getProduct(int prodid);
}
