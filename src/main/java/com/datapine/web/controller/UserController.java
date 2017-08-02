package com.datapine.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.datapine.domain.User;
import com.datapine.service.UserService;

@Controller
@RequestMapping(value = "/users", name = "UserController")
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addNew() {
		return new ModelAndView("/user/add-user");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listUsers() {
		ModelAndView modelAndView = new ModelAndView("user/list");
		modelAndView.addObject("users", service.findAll());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, name = "saveUser")
	public ModelAndView save(User user) {
		service.save(user);
		return listUsers();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView showUser(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("user/update-user");
		modelAndView.addObject("user", service.findById(id));
		return modelAndView;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, name = "updateUser")
	public ModelAndView updateUser(User user) {
		ModelAndView modelAndView = new ModelAndView("user/update-user");
		service.update(user);
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ModelAndView deleteUser(@PathVariable("id") long id) {
		service.delete(service.findById(id));
		return listUsers();
	}
}
