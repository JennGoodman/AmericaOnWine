package com.revature.americaonwine.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.americaonwine.beans.Roles;
import com.revature.americaonwine.beans.User;
import com.revature.americaonwine.services.AdminService;

@RestController
@RequestMapping(headers="Accept=application/json, text/plain")
public class AdminAccountQueueController {
	
	@Autowired
	private AdminService as;
	
	@RequestMapping(value="pendingAccounts", method=RequestMethod.GET)
	public String getPendingRetailerAccounts(HttpSession session, ObjectMapper om) throws JsonProcessingException {
		if (((User) session.getAttribute("user")).getRole() != Roles.numericalRepresentation(Roles.ADMIN)) {
			return null;
		} else {
			return om.writeValueAsString(as.getPendingRetailerAccounts());
		}
	}
	
	@RequestMapping(value="retailerAccounts", method=RequestMethod.GET)
	public String getActivatedRetailerAccounts(HttpSession session, ObjectMapper om) throws JsonProcessingException {
		if (((User) session.getAttribute("user")).getRole() != Roles.numericalRepresentation(Roles.ADMIN)) {
			return null;
		} else {
			return om.writeValueAsString(as.getActivatedRetailerAccounts());
		}
	}
	
	@RequestMapping(value="activateRetailer", method=RequestMethod.POST)
	public boolean activateRetailerAccount(@RequestBody User u, HttpSession session, ObjectMapper om) throws JsonProcessingException {
		if (((User) session.getAttribute("user")).getRole() != Roles.numericalRepresentation(Roles.ADMIN)) {
			return false;
		} else {
			return as.activateRetailerAccount(u);
		}
	}
	
	@RequestMapping(value="cancelRetailer", method=RequestMethod.POST)
	public boolean cancelRetailerAccount(@RequestBody User u, HttpSession session, ObjectMapper om) throws JsonProcessingException {
		if (((User) session.getAttribute("user")).getRole() != Roles.numericalRepresentation(Roles.ADMIN)) {
			return false;
		} else {
			return as.cancelRetailerAccount(u);
		}
	}
	
	@RequestMapping(value="reactivateRetailer", method=RequestMethod.POST)
	public boolean reactivateRetailerAccount(@RequestBody User u, HttpSession session, ObjectMapper om) throws JsonProcessingException {
		if (((User) session.getAttribute("user")).getRole() != Roles.numericalRepresentation(Roles.ADMIN)) {
			return false;
		} else {
			return as.reactivateRetailerAccount(u);
		}
	}
}
