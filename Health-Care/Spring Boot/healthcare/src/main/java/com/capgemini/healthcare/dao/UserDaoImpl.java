package com.capgemini.healthcare.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcare.dto.User;
import com.capgemini.healthcare.exception.UserException;

@Repository
public class UserDaoImpl implements UserDao{

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public User loginUser(User user) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		String jpql = "from User where userEmail=:email ";
		TypedQuery<User> query = manager.createQuery(jpql, User.class);
		query.setParameter("email", user.getUserEmail());
		try {
			User userAccount = query.getSingleResult();
			if (userAccount.getUserPassword().equals(user.getUserPassword())) {
				return userAccount;
			}
		} catch (Exception e) {
		}
		throw new UserException("Invalid User Account please Enter Valid Credentials");

	}

}
