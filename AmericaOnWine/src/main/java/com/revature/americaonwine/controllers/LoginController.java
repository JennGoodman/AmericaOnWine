package com.revature.americaonwine.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.americaonwine.beans.User;
import com.revature.americaonwine.services.LoginService;

@Controller
// @CrossOrigin(origins="http//localhost:8080")
// @CrossOrigin(origins= {"50.207.204.190", "http://localhost:4200", "http://localhost:8080", ""})
@CrossOrigin(origins="*")
@RequestMapping(headers="Accept=application/json, text/plain")
public class LoginController {

	private Logger log = Logger.getLogger(LoginController.class);
	
	@Autowired
	private LoginService ls;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody User fromWeb, ObjectMapper om, HttpSession session) throws JsonProcessingException {
		log.trace("Got Request body and is : " + fromWeb);
		if ((User) session.getAttribute("user") != null) {
			// this needs to change.
			return om.writeValueAsString(session.getAttribute("user"));
		} 
		else {
			User fromDB = ls.login(fromWeb.getUsername(), fromWeb.getPassword());
			log.trace("User is : " + fromDB);
			if (fromDB != null) {
				log.trace(" User form DB is not null and is: " + fromDB);
				session.setAttribute("user", fromDB);
				return om.writeValueAsString(fromDB);
			} else {
				log.trace(" Did  not find user in the DB");
				return om.writeValueAsString(fromDB);
			}
		}
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	@ResponseBody
	public String logout(HttpSession session) {
		log.trace("Logout called");
		session.invalidate();
		return null;
	}
}
