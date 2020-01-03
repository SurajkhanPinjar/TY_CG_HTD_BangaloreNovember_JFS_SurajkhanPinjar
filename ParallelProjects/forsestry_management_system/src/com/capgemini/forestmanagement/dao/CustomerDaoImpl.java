package com.capgemini.forestmanagement.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import com.capgemini.forestmanagement.bean.ClientBean;
import com.capgemini.forestmanagement.bean.ContractBean;
import com.capgemini.forestmanagement.bean.CustomerBean;
import com.capgemini.forestmanagement.exception.CustomerExceptions;
import com.capgemini.forestmanagement.factory.Validation;
import com.capgemini.forestmanagement.main.MainHome;

public class CustomerDaoImpl implements CustomerDao {
	private List<CustomerBean> cust= new ArrayList<CustomerBean>();
	CustomerBean bean1= new CustomerBean();
	Scanner sc1=new Scanner(System.in);


	@Override
	public boolean addCustomer(CustomerBean bean) {
		for (CustomerBean customerBean : cust) {
			if(customerBean.getTelephone() == bean.getTelephone()) {
				throw new CustomerExceptions("Customer Cannot be Added\nCustomer Id Already Existed");
			}
		}
		cust.add(bean);
		return true;

	}

	@Override
	public boolean deleteCustomer(int custId) {
		for (CustomerBean customerBean : cust) {
			if(((customerBean.getCustId())==custId)) {
				cust.remove(customerBean);
				return true;
			}
		}
		throw new CustomerExceptions("Customer Account Cannot be Deleted\nEnter Valid Customer Id ");
	}

	@Override
	public boolean modifyCustomer(int custId) {

		for (CustomerBean customerBean : cust) {
			if((customerBean.getCustId()) == custId){
				int i = 1;
				while(i==1) {
					int c=0;
					char shh1 = 'y';
					while( shh1 == 'y') {
						System.out.println("Choose field  to be modify\nEnter 1 : Customer Name\nEnter 2 : Street1\n"
								+ "Enter 3 : Street2\nEnter 4 : Town\nEnter 5 : PostalCode\nEnter 6 : email\n"
								+ "Enter 7 : Back\nEnter 8 : Home");
						String v1 = sc1.next();
						if (Validation.isNumber1(v1)) {
							c = Integer.parseInt(v1);
							shh1 ='n';
						}else {
							System.out.println("Enter only integers:");
						}
					}	
					
					switch (c) {
					case 1:
						char b4 = 'y';
						while(b4 == 'y') {
							System.out.println("Enter Name to be modify.. ");
							String cadd3 = sc1.next();
							if (Validation.isStringOnlyAlphabet(cadd3)) {
								b4 = 'n';
								customerBean.setCustomerName(cadd3);
								System.out.println("Modified Successfully :)");
							}else {
								System.out.println("Enter currect Format!!!!");
							}
						}
						break;

					case 2:
							System.out.println("Enter Address1 ");
							customerBean.setStreetAdd1(sc1.next());
							System.out.println("Modified Successfully :)");
						break;

					case 3:
							System.out.println("Enter Address2 ");
								customerBean.setStreetAdd2(sc1.next());
								System.out.println("Modified Successfully :)");
						break;

					case 4:
						char b7 = 'y';
						while(b7 == 'y') {
							System.out.println("Enter Town... ");
							String cadd3 = sc1.next();
							if (Validation.isStringOnlyAlphabet(cadd3)) {
								b7 = 'n';
								customerBean.setTown(cadd3);
								System.out.println("Modified Successfully :)");
							}else {
								System.out.println("Enter currect Format!!!!");
							}
						}
						break;
					
					case 5:
						char chh2 = 'y';
						while( chh2 == 'y') {
							System.out.println("Enter the Telephone: ");
							String v1 = sc1.next();
							if (Validation.isValidTel(v1)) {
								long v22 = Long.parseLong(v1);
								customerBean.setTelephone(v22);
								chh2 ='n';
							}else {
								System.err.println("Enter only integers:");
							}
						}		
						break;

					case 6:
						char b8 = 'y';
						while(b8 == 'y') {
							System.out.println("Enter the Email: ");
							String cadd3 = sc1.next();
							if (Validation.isValid(cadd3)) {
								b8 = 'n';
								customerBean.setEmail(cadd3);
								System.out.println("Modified Successfully :)");
							}else {
								System.out.println("Email currect Format!!!!");
							}
						}
						break;

					case 7:
						i = 0 ;
						break;

					case 8:
						MainHome.mainHome();
						break;
						
					default:
						System.err.println("Invalid Choice :(");
						break;
					}
				}
				return true;				
			}
		}
		throw new CustomerExceptions("Customer Cannot be Modified\nEnter Valid Client Id");
	}

	@Override
	public List<CustomerBean> showAllCustomer(CustomerBean bean) {
		
		if (cust!= null) {
			return cust;
		}
		throw new CustomerExceptions("Customer Not Present");
	}

	@Override
	public List<CustomerBean> searchCustomer(int custId) {
		for (CustomerBean customerBean : cust) {
			if(customerBean.getCustId() == custId) {
				return cust;
			}
		}
		throw new CustomerExceptions("Customer Cannot be Found\nEnter Valid Customer Id");
	}



}
