	package com.capgemini.forestmanagement.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagement.bean.ClientBean;
import com.capgemini.forestmanagement.bean.CustomerBean;
import com.capgemini.forestmanagement.exception.ClientExceptions;
import com.capgemini.forestmanagement.factory.Validation;
import com.capgemini.forestmanagement.main.ClientSection;

public class ClientDaoImpl implements ClientDao{

	Scanner sc = new Scanner(System.in);
	List< ClientBean> b1 = new ArrayList<ClientBean>();
	ClientBean b = new ClientBean();

	@Override
	public boolean addClient(ClientBean bean) {
		for (ClientBean clientBean : b1) {
			if(clientBean.getCId()==bean.getCId()) {
				System.err.println("Client Id Already Exised");
				throw new ClientExceptions("Client Cannot be Added");
			}
		}
		b1.add(bean);
		return true;
	}

	@Override
	public boolean loginClient(Object cid, String cpass) {
		for (ClientBean clientBean : b1) {
			if(cid.equals(clientBean.getCId()) && cpass.equals(clientBean.getCPass()) ) {
				return true;
			}
		}
		throw new ClientExceptions("Invalid Client");
	}

	@Override
	public List<ClientBean> searchClient(int clientid) {
		for (ClientBean clientBean : b1) {
			if(clientBean.getCId() == clientid) {
				return b1;
			}
		}
		throw new ClientExceptions("Client Cannot be Found\nUse Valid Client Id");
	}

	@Override
	public List<ClientBean> getAllClient() {
		if (b1!= null) {
			return b1;
		} 
		throw new ClientExceptions("No client Account present");

	}

	@Override
	public boolean deleteClient(int clientid) {
		for (ClientBean clientBean : b1) {
			if(((clientBean.getCId())==clientid) ) {
				b1.remove(clientBean);
				return true;
			}
		}
		throw new ClientExceptions("Client Cannot be Deleted\nEnter Valid Client Id");
	}

	@Override
	public boolean updateClient(int clientid) {
		for (ClientBean clientBean : b1) {
			if(clientBean.getCId() == clientid) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter The Choices for Modification:");

				int i = 1;
				while (i==1) {
				int c=0;
				char chh1 = 'y';
				while( chh1 == 'y') {
					System.out.println("Enter 1 : Client Name\nEnter 2 : Client Password\nEnter 3 : Back");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						c = Integer.parseInt(v1);
						chh1 ='n';
					}else {
						System.out.println("Enter only integers:");
					}
				}
				switch (c) {
				case 1:
					
					char a1 = 'y';
					while(a1 == 'y') {
						System.out.println("Enter The Name To Modify");
						String cname = sc.next();
						if (Validation.isStringOnlyAlphabet(cname)) {
							a1 = 'n';
							clientBean.setCName(cname);				
						}else {
							System.err.println("Enter only Alphabets!!!!");
						}
					}
					return true;
					
				case 2 :
					char m1 = 'y';
					while(m1 == 'y') {
						System.out.println("Enter the Password:");
						String cadd3 = sc.next();
						int strength = Validation.calculatePasswordStrength(cadd3);
						System.out.println("Your Password Strength is :" +strength);
						if (strength == 10) {
							m1 = 'n';
							clientBean.setCPass(cadd3);				
						}else {
							System.err.println("The Password Strength is not Strong :( \nThe Password Should contain min 8 digits  "
									+ " Atleast 1 Upper case,1 lower cases, 1 special charecter and integers :)");
						}
					}
					
					return true;
				case 3 :
					ClientSection.clientSection();
				default:
					System.out.println("Invalid Choice");
					break;
				}
			}
			}
		}
		throw new ClientExceptions("Cannot be Modified\nEnter Valid Client Id");
	}


}
