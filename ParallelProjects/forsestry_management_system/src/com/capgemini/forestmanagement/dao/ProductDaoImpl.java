package com.capgemini.forestmanagement.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagement.bean.ProductBean;
import com.capgemini.forestmanagement.exception.ProductExceptions;
import com.capgemini.forestmanagement.factory.Validation;

public class ProductDaoImpl implements ProductDao {
	List<ProductBean> l1= new ArrayList<ProductBean>();
	ProductBean bea=new ProductBean();
	Scanner sc=new Scanner(System.in);

	@Override
	public boolean addProduct(ProductBean bean) {
		for (ProductBean productBean : l1) {
			if(productBean.getProdId()==bean.getProdId()) {
				throw new ProductExceptions("Product Details Cannot be Added\nProduct Id Already Existed");
			}
		}
		l1.add(bean);
		return true;
	}

	@Override
	public boolean deleteProduct(int prodid) {
		for (ProductBean productBean : l1) {
			if(productBean.getProdId()==prodid) {
				l1.remove(productBean);
				return true;
			}
		}
		throw new ProductExceptions("Product Cannot be deleted\nEnter Valid Product Id");
	}

	@Override
	public boolean modifyProduct(int prodid) {
		for (ProductBean productBean : l1) {
			if(productBean.getProdId()==prodid) {
				char b4 = 'y';
				while(b4 == 'y') {
					System.out.println("Enter the Product Name : ");
					String cadd3 = sc.next();
					if (Validation.isStringOnlyAlphabet(cadd3)) {
						b4 = 'n';
						productBean.setProdName(cadd3);				
					}else {
						System.out.println("Enter currect Format!!!!");
					}
					}
				
				return true;
			}
		}
		throw new ProductExceptions("Product Cannot be Modified\nEnter Valid Product Id");
	}

	@Override
	public boolean getProduct(int prodid) {
		for (ProductBean productBean : l1) {
			if(productBean.getProdId()==prodid) {
				System.out.println("Prod id	 : "+ productBean.getProdId());
				System.out.println("Prod Name: "+ productBean.getProdName());
				return true;
			}
		}
		throw new ProductExceptions("Product Cannot be Found\nEnter Valid Product Id");
	}
	

}
