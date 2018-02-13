package com.revature.americaonwine.delegates;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
@RequestMapping(value="/login", headers="Accept=application/json, text/plain", consumes= MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

	private Logger log = Logger.getLogger(LoginController.class);
	
	@Autowired
	private LoginService ls;
	
	private ObjectMapper om = new ObjectMapper();
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody User fromWeb, HttpSession session) throws JsonProcessingException {
		log.trace("Got Request body and is : " + fromWeb);
		User fromDB = ls.login(fromWeb.getUsername(), fromWeb.getPassword());
		if (fromDB != null) {
			log.trace(" User form DB is not null and is: " + fromDB);
			session.setAttribute("user", fromDB);
			return om.writeValueAsString(fromDB);
		} else {
			log.trace(" Did  not find user in the DB");
			return om.writeValueAsString(fromDB);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String getPage(HttpSession s) {
		if ((User) s.getAttribute("user") != null) {
			try {
				return om.writeValueAsString("Got To Home");
			} catch (JsonProcessingException e) {
				log.error(e.getMessage());
			}
		}
		return "Stuff";
	}
}
