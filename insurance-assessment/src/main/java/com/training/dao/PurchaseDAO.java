package com.training.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.training.entity.Purchase;
import com.training.util.JPAUtil;

@Repository
public class PurchaseDAO {

    public void savePurchase(Purchase purchase) {
    	System.out.println("Purchase DAO called...");
        EntityManager em = JPAUtil.getEntityManager();
        System.out.println("PurchaseDAO: Saving purchase for policy: " + 
                          purchase.getPolicy().getPolicyType());

        try {
            em.getTransaction().begin();
            em.persist(purchase);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public List<Purchase> findByCustomerId(int customerId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                    "FROM Purchase p WHERE p.customer.id = :customerId", 
                    Purchase.class)
                    .setParameter("customerId", customerId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

}
