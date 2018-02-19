package com.revature.americaonwine.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.beans.User;
import com.revature.americaonwine.services.InventoryService;

@RestController
@RequestMapping(value="/inventory", headers="Accept=application/json, text/plain")
public class InventoryController {
	@Autowired
	private InventoryService is;
	
	
	@RequestMapping(method=RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public String addInventory(@RequestBody InventoryItem inv, ObjectMapper om, HttpSession ses) throws JsonProcessingException {
		User u = (User) ses.getAttribute("user");
		if(u != null) {
			inv.setUserId(u.getId());
		}
		return om.writeValueAsString(is.add(inv));
	}
	
	@RequestMapping(method=RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public String getAll(HttpSession ses, ObjectMapper om) throws JsonProcessingException {
		User u = (User) ses.getAttribute("user");
		if (u == null) {
			u = new User();
			u.setRole(2);
		}
		return om.writeValueAsString(is.getForUser(u));
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.PUT, produces= {"application/json; charset=UTF-8"})
	public String editInventory(HttpSession sess, @RequestBody InventoryItem inv, ObjectMapper om) throws JsonProcessingException {
		User u = (User) sess.getAttribute("user");
		if (u == null) {
			return null;
		}
		if (u.getId() == inv.getUserId())
			return om.writeValueAsString(is.updateInventoryItem(inv));
		return null;
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.PUT, produces= {"application/json; charset=UTF-8"})
	public String removeInventory(HttpSession sess, @RequestBody InventoryItem inv, ObjectMapper om) throws JsonProcessingException {
		User u = (User) sess.getAttribute("user");
		if (u == null)
			return null;
		if (u.getId() == inv.getUserId())
			return om.writeValueAsString(is.removeInventoryItem(inv));
		return null;
	}
}
