package com.adp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adp.db.UserDao;
import com.adp.db.model.User;



@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public User getUser(Long id)
	{
		return userDao.getUserById(id);
	}

	public Long createUser(User user) {
		return userDao.createUser(user);
	}
	public void updateUser(User user) {
		userDao.update(user);
	}

	public List<User> getUsers() {
		
		return userDao.getUserList();
	}
}
