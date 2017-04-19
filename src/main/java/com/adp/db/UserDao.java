package com.adp.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.adp.db.model.User;

@Repository
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Long createUser(User user) {
		entityManager.persist(user);
		entityManager.flush();
		return user.getId();
	}
	
	public User getUserById(Long id) {
		return entityManager.find(User.class, id);
	}

	public void update(User user) {
		entityManager.merge(user);
		
	}

	public List<User> getUserList() {
		return entityManager.createQuery("Select u from User u", User.class).getResultList();
		
	}
}
