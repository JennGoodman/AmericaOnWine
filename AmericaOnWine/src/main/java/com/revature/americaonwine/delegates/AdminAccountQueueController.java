package com.revature.americaonwine.delegates;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.americaonwine.beans.Roles;
import com.revature.americaonwine.beans.User;
import com.revature.americaonwine.services.AdminService;

@Controller
@CrossOrigin(origins="*")
@RequestMapping(headers="Accept=application/json, text/plain")
public class AdminAccountQueueController {
	private Logger log = Logger.getLogger(AdminAccountQueueController.class);
	
	@Autowired
	private AdminService as;
	
	private ObjectMapper om = new ObjectMapper();
	
	@RequestMapping(value="pendingAccounts", method=RequestMethod.GET)
	public String getPendingRetailerAccounts(HttpSession session) throws JsonProcessingException {
		log.trace("getPendingRetailerAccounts handling request");
		if (((User) session.getAttribute("user")).getRole() != Roles.numericalRepresentation(Roles.ADMIN)) {
			return null;
		} else {
			return om.writeValueAsString(as.getPendingRetailerAccounts());
		}
	}
}
