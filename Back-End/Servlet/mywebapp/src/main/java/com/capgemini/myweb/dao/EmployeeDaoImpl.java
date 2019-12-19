package com.capgemini.myweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.myweb.beans.EmployeeInfoBean;

public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManagerFactory entityManaFactory = Persistence.createEntityManagerFactory("Test");
	
	@Override
	public EmployeeInfoBean searchEmployee(int empId) {
	 EntityManager entityManager = entityManaFactory.createEntityManager();
	 EmployeeInfoBean employeeBean = entityManager.find(EmployeeInfoBean.class, empId);
	 entityManager.close();
	 return employeeBean;
	 
	}// End Of searchEmployee()

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		EntityManager entiManager = entityManaFactory.createEntityManager();
		String jpql =  "from EmployeeInfoBean where empId = :empId and password = :pwd ";
		Query query = entiManager.createQuery(jpql);
		query.setParameter("empId", empId);
		query.setParameter("pwd", password);
		
		EmployeeInfoBean employeeInfoBean = null;
		try {
			employeeInfoBean= (EmployeeInfoBean) query.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		entiManager.close();
		return employeeInfoBean;
		
	}

	@Override
	public boolean addEmployee(EmployeeInfoBean empBean) {
		boolean res = false;
		EntityManager entityManager = entityManaFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			
			entityManager.persist(empBean);
			transaction.commit();
			res = true;
			
		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		return res;
	}

	

	@Override
	public boolean deleteEmployee(int empId) {
		boolean isDeleted = false;
		
		EntityManager entityManager = entityManaFactory.createEntityManager();
		EmployeeInfoBean emploInfoBean = entityManager.find(EmployeeInfoBean.class, empId);
		EntityTransaction transaction = null;
		if (emploInfoBean != null) {
			transaction= entityManager.getTransaction();
			transaction.begin();
			entityManager.remove(emploInfoBean);
			transaction.commit();
			isDeleted = true;
		}
		entityManager.close();
		
		return isDeleted;
	} //End Of Delete Method

	@Override
	public boolean updateEmployee(EmployeeInfoBean empBean) {
		boolean isUpdated = false;
//		EmployeeInfoBean bean = new EmployeeInfoBean();
		
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager manager = managerFactory.createEntityManager();
		EmployeeInfoBean existingEmployeeInfo = manager.find(EmployeeInfoBean.class, empBean.getEmpId() );
		
		EntityTransaction transaction = manager.getTransaction();
		
		if(existingEmployeeInfo != null) {
			try {
				transaction.begin();
				String newName = empBean.getName().trim();
				if (newName != null && !newName.isEmpty()) {
					existingEmployeeInfo.setName(newName);
				}
				
				int newAge = empBean.getAge();
				if(newAge > 18) {
					existingEmployeeInfo.setAge(newAge);
				}
				
				double newSal = empBean.getSalary();
				if(newSal > 0 ) {
					existingEmployeeInfo.setSalary(newSal);
				}
				
				String newDesign = empBean.getDesignation();
				if (newDesign != null && !newDesign.isEmpty()) {
					existingEmployeeInfo.setDesignation(newDesign);
				}
				
				String newPass = empBean.getPassword();
				if (newPass != null && !newPass.isEmpty()) {
					existingEmployeeInfo.setSalary(newSal);
				}
				transaction.commit();
				
				isUpdated = true;
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		manager.close();
		return isUpdated;
		
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		EntityManager entityManager = entityManaFactory.createEntityManager();
		String jpql = "from EmployeeInfoBean" ;
		Query query = entityManager.createQuery(jpql);
		List<EmployeeInfoBean> employeeList = query.getResultList();
		
		return employeeList;
		
	}
	

}// End Of Class
