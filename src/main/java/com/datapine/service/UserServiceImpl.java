package com.datapine.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datapine.dao.UserDAO;
import com.datapine.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	@Override
	public User register(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updatePassword(Long userId, String oldPassword,
			String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<User> findAll() {
		return dao.findAllOrderById();
	}

	@Override
	@Transactional
	public void save(User user) {
		dao.save(user);
	}

	@Override
	public User findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public User update(User user) {
		return dao.update(user);
	}

	@Override
	public void delete(User user) {
		dao.delete(user);
	}
}
