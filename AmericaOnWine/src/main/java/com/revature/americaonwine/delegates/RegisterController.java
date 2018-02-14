package com.revature.americaonwine.delegates;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
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
//@CrossOrigin(origins= "http://localhost:4200")
@CrossOrigin(origins="*")
@RequestMapping(value="/register", headers="Accept=application/json, text/plain")
public class RegisterController {
	
	    @Autowired
		private LoginService ser;
		private ObjectMapper om = new ObjectMapper();
		
		@RequestMapping(method=RequestMethod.POST)
		@ResponseBody
		public String register(@RequestBody User fromWeb, HttpSession session) throws JsonProcessingException {
			
			User fromDB = ser.register(fromWeb);
			
			if(fromDB != null) {
				fromDB = ser.register(fromWeb);
				session.setAttribute("user", fromDB);
				return om.writeValueAsString(fromDB);
			}
			else {
				return null;
			}
			
		}

}
