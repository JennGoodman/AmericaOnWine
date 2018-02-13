package com.revature.americaonwine.delegates;

import javax.servlet.http.HttpSession;

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
//@CrossOrigin(origins="http//localhost:8080")
@CrossOrigin(origins="18.219.46.59:8080")
@RequestMapping(value="/login")
public class LoginController {
	
	@Autowired
	private LoginService ls;
	
	private ObjectMapper om = new ObjectMapper();
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody User fromWeb, HttpSession session) throws JsonProcessingException {
		
		User fromDB = ls.login(fromWeb.getUsername(), fromWeb.getPassword());
		if (fromDB != null) {
			session.setAttribute("user", fromDB);
			return om.writeValueAsString(fromDB);
		} else {
			return null;
		}
	}

}
