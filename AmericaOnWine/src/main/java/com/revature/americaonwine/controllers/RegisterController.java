package com.revature.americaonwine.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.americaonwine.beans.Roles;
import com.revature.americaonwine.beans.User;
import com.revature.americaonwine.services.LoginService;

@Controller
@RequestMapping(headers="Accept=application/json, text/plain")
public class RegisterController {
	@Autowired
	private LoginService ser;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	@ResponseBody
	public String register(@RequestBody User fromWeb, ObjectMapper om, HttpSession session) throws JsonProcessingException {
		User fromDB = ser.register(fromWeb);
		if(fromDB != null) {
			if (fromDB.getRole() != Roles.numericalRepresentation(Roles.RETAILER))
				session.setAttribute("user", fromDB);
			fromDB = ser.register(fromWeb);
			return om.writeValueAsString(fromDB);
		}
		else {
			return null;
		}
		
	}

}
