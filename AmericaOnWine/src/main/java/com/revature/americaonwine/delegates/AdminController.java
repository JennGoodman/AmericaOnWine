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
import com.revature.americaonwine.services.AdminService;

@Controller
//@CrossOrigin(origins= "http://localhost:4200")
@CrossOrigin(origins="*")
@RequestMapping(headers="Accept=application/json, text/plain")
public class AdminController {
	private Logger log = Logger.getLogger(AdminController.class);
	@Autowired
	private AdminService as;
	private ObjectMapper om = new ObjectMapper();
	
	@RequestMapping(value="/inventory", method=RequestMethod.POST)
	@ResponseBody
	public String InventoryItemApproval(@RequestBody InventoryItem fromWeb, HttpSession session) throws JsonProcessingException {
		return om.writeValueAsString(null);
	}
	
	//need to modify the value
//	@RequestMapping(value="/inventory", method=RequestMethod.POST)
//	@ResponseBody
//	public String deny(@RequestBody InventoryItem fromWeb, HttpSession session) throws JsonProcessingException {
//		return om.writeValueAsString(null);
//	}
	
}
