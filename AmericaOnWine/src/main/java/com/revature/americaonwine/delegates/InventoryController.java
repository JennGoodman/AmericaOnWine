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
import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.beans.User;
import com.revature.americaonwine.services.InventoryService;

@Controller
@CrossOrigin
@RequestMapping(value="/inventory", headers="Accept=application/json, text/plain")
public class InventoryController {
	@Autowired
	private InventoryService is;
	@Autowired
	private User user;
	
	@Autowired
	private ObjectMapper om;
	
	@RequestMapping(method=RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public String addInventory(@RequestBody InventoryItem inv) throws JsonProcessingException {
		return om.writeValueAsString(inv);
	}
	
	@RequestMapping(method=RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public String getAll(HttpSession ses) throws JsonProcessingException {
		User u = (User) ses.getAttribute("user");
		if(u == null) {
			user.setRole(0);
			return om.writeValueAsString(is.getForUser(user));
		} else {
			return om.writeValueAsString(is.getForUser(u));
		}
	}
	
	@RequestMapping(value="inventory/edit",method=RequestMethod.POST, produces= {"application/json; charset=UTF-8"})
	@ResponseBody
	public String editInventory(HttpSession sess, @RequestBody InventoryItem inv) throws JsonProcessingException {
		User u = (User) sess.getAttribute("user");
		if (u == null) {
			return null;
		}
		if (u.getId() == inv.getUserId())
			return om.writeValueAsString(is.updateInventoryItem(inv));
		return null;
	}
	
	@RequestMapping(value="/inventory/remove", method=RequestMethod.POST, produces= {"application/json; charset=UTF-8"})
	@ResponseBody
	public String removeInventory(HttpSession sess, @RequestBody InventoryItem inv) throws JsonProcessingException {
		User u = (User) sess.getAttribute("user");
		if (u == null)
			return null;
		if (u.getId() == inv.getUserId())
			return om.writeValueAsString(is.removeInventoryItem(inv));
		return null;
	}
	
}
