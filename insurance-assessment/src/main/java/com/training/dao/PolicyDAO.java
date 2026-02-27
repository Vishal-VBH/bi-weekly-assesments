package com.training.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import com.training.entity.Policy;
import com.training.util.JPAUtil;

@Repository
public class PolicyDAO {

    public List<Policy> findAllPolicies() {
        EntityManager em = JPAUtil.getEntityManager();
        System.out.println("PolicyDAO:Called");

        try {
            return em.createQuery("FROM Policy", Policy.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void savePolicy(Policy policy) {
        EntityManager em = JPAUtil.getEntityManager();
        System.out.println("PolicyDAO: Saving policy: " + policy.getPolicyType());

        try {
            em.getTransaction().begin();
            em.persist(policy);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void deletePolicy(Long policyId) {
        EntityManager em = JPAUtil.getEntityManager();
        System.out.println("PolicyDAO: Deleting policy ID: " + policyId);

        try {
            em.getTransaction().begin();
            Policy policy = em.find(Policy.class, policyId);
            if (policy != null) {
                em.remove(policy);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    public Policy findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Policy.class, id);
        } finally {
            em.close();
        }
    }

}
