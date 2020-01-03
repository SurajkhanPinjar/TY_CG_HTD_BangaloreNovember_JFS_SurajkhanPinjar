package com.capgemini.forestmanagement.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagement.bean.ClientBean;
import com.capgemini.forestmanagement.bean.ContractBean;
import com.capgemini.forestmanagement.bean.LandBean;
import com.capgemini.forestmanagement.exception.LandExceptions;
import com.capgemini.forestmanagement.factory.Validation;

public class LandDaoImpl implements LandDao {
	private List<LandBean> list= new ArrayList<LandBean>();
	LandBean bean = new LandBean();
	
	@Override
	public boolean addLand(LandBean lbean) {
		for (LandBean landBean : list) {
			if (lbean.getLandId() == landBean.getLandId()) {
				throw new LandExceptions("Land Details Cannot be Added\nLand Id Already Existed");
					
			}
		}
		list.add(lbean);
		return true;
	}

	@Override
	public boolean deleteLand(int landid) {
		for (LandBean landBean : list) {
			if (landid == landBean.getLandId()) {
				list.remove(landBean);
				return true;
			}
		}
		throw new LandExceptions("Land Details cannot be Deleted\nEnter Valid Land Id");
	}

	@Override
	public boolean modifyLand(int landid) {
		for (LandBean landBean : list) {
			if (landBean.getLandId() == landid) {
				
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter The Choices for Modification:");

				int i = 1;
				while (i==1) {
				int c=0;
				char chh1 = 'y';
				while( chh1 == 'y') {
					System.out.println("1.Land Location\n2.Land Value\n3.Owner Name\n4.Acquire Date");
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
					System.out.println("Enter The Land Location to modify");
					landBean.setLocation(sc.next());
					return true;

				case 2 :
					System.out.println("Enter The Land Value Modify ");
					landBean.setValue(sc.nextInt());
					return true;
				
				case 3:
					System.out.println("Enter The Owner Name to Modify");
					landBean.setOwnerName(sc.next());
					return true;
				
				case 4:
					System.out.println("Acquire Date to Modify ");
					landBean.setDate(sc.next());
					return true;
				
				case 5:
					break;
				default:
					System.out.println("Invalid Choice");
					break;
				}
				
			}
		}
		}
		throw new LandExceptions("Land Details Cannot be Modified\nEnter Valid Land Id");
	}

	@Override
	public List<LandBean> searchLand(int landid) {
		for (LandBean landBean : list) {
			if (landid == landBean.getLandId()) {
				List< LandBean> l1 = new ArrayList<LandBean>();
				l1.add(landBean);
				return l1;
			}
		}
		throw new LandExceptions("Land Details Cannot be found\nEnter Valid Land Id");
	}

	@Override
	public List<LandBean> getAllLand() {
		List<LandBean> l = new ArrayList<LandBean>();
		for (LandBean landBean : list) {
			if ( list!= null && !list.isEmpty()) {
				l.add(landBean);
				return l;
				
			}
		}
		throw new LandExceptions("No Land Details Present");
			
	}

}
