package com.datapine.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	public void login(String email, String password) {
		logger.info(email + " loggin attempt");
	}
}
