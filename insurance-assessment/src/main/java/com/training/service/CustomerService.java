package com.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.dao.CustomerDAO;
import com.training.entity.Customer;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public Customer findByEmailAndPassword(String email, String password) {
        System.out.println("CustomerService: Login validation called");
        return customerDAO.findByEmailAndPassword(email, password);
    }

    public void registerCustomer(String name, String email, long phone, String address, String password) {
        System.out.println("CustomerService: Registering new customer");
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setAddress(address);
        customer.setPassword(password);
        
        customerDAO.saveCustomer(customer);
    }
}

