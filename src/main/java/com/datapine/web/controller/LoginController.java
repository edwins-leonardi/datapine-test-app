package com.datapine.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.datapine.service.LoginService;

@Controller
@RequestMapping(value = "/login", name = "LoginController")
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private LoginService service;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView form() {
		return new ModelAndView("login");
	}

	@RequestMapping(method = RequestMethod.POST, name = "login")
	public ModelAndView dologin(String email, String password) {
		logger.info("login controller");
		service.login(email, password);
		return new ModelAndView("index");
	}
}
