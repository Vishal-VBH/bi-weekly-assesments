package com.training.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dao.CustomerDAO;
import com.training.dao.PolicyDAO;
import com.training.dao.PurchaseDAO;
import com.training.entity.Customer;
import com.training.entity.Policy;
import com.training.entity.Purchase;

@Service
public class PurchaseService {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private PolicyDAO policyDAO;

    @Autowired
    private PurchaseDAO purchaseDAO;

    public void purchasePolicy(int customerId, int policyId) {
        System.out.println("PurchaseService: Processing purchase - Customer: " + customerId + ", Policy: " + policyId);
        
        // Fetch customer n his associated policies
        Customer customer = customerDAO.findById(customerId);
        Policy policy = policyDAO.findById(policyId);
        
        // save purchase record
        Purchase purchase = new Purchase();
        purchase.setCustomer(customer);
        purchase.setPolicy(policy);
        purchase.setPurchaseDate(new Date());
        
        purchaseDAO.savePurchase(purchase);
    }

    public Policy getPolicyById(int policyId) {
        System.out.println("PurchaseService: Getting policy by ID: " + policyId);
        return policyDAO.findById(policyId);
    }
    
    public List<Purchase> getCustomerPurchases(int customerId) {
        System.out.println("PurchaseService: Fetching purchases for customer: " + customerId);
        return purchaseDAO.findByCustomerId(customerId);
    }


}
