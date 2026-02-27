package com.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dao.UserDAO;
import com.training.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public boolean validateLogin(String name, String password) {
		System.out.println("Spring Service Called");

		User user = userDAO.findByNameAndPassword(name, password);

		return user != null;
	}

	public void registerUser(String username, String password) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setName(username);
		user.setPassword(password);

		userDAO.saveUser(user);

	}

}