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
@RequestMapping(headers="Accept=application/json, text/plain")
public class RegisterController {
	private Logger log = Logger.getLogger(RegisterController.class);
	    @Autowired
		private LoginService ser;
		
		@RequestMapping(value="/register", method=RequestMethod.POST)
		@ResponseBody
		public String register(@RequestBody User fromWeb, ObjectMapper om, HttpSession session) throws JsonProcessingException {
			log.trace("Got Request body and is : " + fromWeb);
			User fromDB = ser.register(fromWeb);
			
			if(fromDB != null) {
				log.trace("Didn't find user in the DB, valid user");
				fromDB = ser.register(fromWeb);
				session.setAttribute("user", fromDB);
				return om.writeValueAsString(fromDB);
			}
			else {
				log.trace("Found user in the DB, return null");
				return null;
			}
			
		}

}
