package com.datapine.dao;

import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.datapine.domain.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(User user) {
		em.persist(user);
	}

	@Override
	public User update(User user) {
		return em.merge(user);
	}

	@Override
	public void delete(User user) {
		em.remove(user);
	}

	@Override
	public User findById(Long id) {
		return em.find(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		Query query = em
				.createQuery("select u from User u where u.email = :email");
		query.setParameter("email", email);
		return (User) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<User> findAllOrderById() {
		Query query = em.createQuery("select u from User u order by id");
		return query.getResultList().iterator();
	}
}
