package com.datapine.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public void login(String email, String password) {
		System.out.println(email + " loggin attempt");
	}
}
