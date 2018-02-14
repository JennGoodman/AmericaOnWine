package com.revature.americaonwine.delegates;

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
import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.beans.User;
import com.revature.americaonwine.services.InventoryService;

@Controller
@CrossOrigin(origins="*")
@RequestMapping(value="/inventory", headers="Accept=application/json, text/plain")
public class InventoryController {
	@Autowired
	private InventoryService is;
	
	private Logger log = Logger.getLogger(InventoryController.class);
	private ObjectMapper om = new ObjectMapper();
	
	@RequestMapping(method=RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public String addInventory(@RequestBody InventoryItem inv) throws JsonProcessingException {
		log.trace("addInventory called, requested inventory item is ");
		log.trace(inv.toString());
		return om.writeValueAsString(is.add(inv));
	}
	
	@RequestMapping(method=RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public String getAll(HttpSession ses) throws JsonProcessingException {
		log.trace("what");
		User u = (User) ses.getAttribute("user");
		if(u == null) {
			return om.writeValueAsString(is.getAll());
		} else {
			return om.writeValueAsString(is.getForUser(u));
		}
	}

}
