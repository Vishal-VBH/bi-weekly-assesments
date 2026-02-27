package com.training.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.training.entity.User;
import com.training.util.JPAUtil;

@Repository
public class UserDAO {

    public User findByNameAndPassword(String name, String password) {

        EntityManager em = JPAUtil.getEntityManager();
        System.out.println("Hibernate DAO Called");

        try {
            return em.createQuery(
                    "FROM User u WHERE u.name = :name AND u.password = :pwd",
                    User.class)
                    .setParameter("name", name)
                    .setParameter("pwd", password)
                    .getSingleResult();

        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public void saveUser(User user) {
        // TODO Auto-generated method stub
        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        em.close();
        
    }
}