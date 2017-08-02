package com.datapine.service;

import java.util.Iterator;

import com.datapine.domain.User;

public interface UserService {

	User register(String email, String password);

	User updatePassword(Long userId, String oldPassword, String newPassword);

	Iterator<User> findAll();

	void save(User user);

	User findById(Long id);

	User update(User user);

	void delete(User user);
}
