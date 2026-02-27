package com.training.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.training.entity.Customer;
import com.training.util.JPAUtil;

@Repository
public class CustomerDAO {

	public Customer findByEmailAndPassword(String email, String password) {
	
		 EntityManager em = JPAUtil.getEntityManager();
	        System.out.println("Hibernate DAO Called");

	        try {
	            return em.createQuery(
	                    "FROM Customer u WHERE u.email = :email AND u.password = :pwd",
	                    Customer.class)
	                    .setParameter("email", email)
	                    .setParameter("pwd", password)
	                    .getSingleResult();

	        } catch (NoResultException e) {
	            return null;
	        } finally {
	            em.close();
	        }
	}

	   public void saveCustomer(Customer customer) {
	        EntityManager em = JPAUtil.getEntityManager();
	        em.getTransaction().begin();
	        em.persist(customer);
	        em.getTransaction().commit();
	        em.close();
	    }
	   
	   public Customer findById(int id) { 
	       EntityManager em = JPAUtil.getEntityManager();
	       try {
	           return em.find(Customer.class, id);
	       } finally {
	           em.close();
	       }
	   }



}
