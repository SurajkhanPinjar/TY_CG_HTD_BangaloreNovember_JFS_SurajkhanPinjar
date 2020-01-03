
package com.capgemini.forestry.services;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestry.bean.ProductBean;

public interface ProductServices {
	public boolean addProduct(ProductBean bean);
	public boolean deleteProduct(int productid);
	public boolean modifyProduct(int productid, String productname);
	public ArrayList<ProductBean> getProduct(int productid);
	public ArrayList<ProductBean> getAllProduct();

}
