package com.revature.americaonwine.delegates;

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
import com.revature.americaonwine.services.InventoryService;

@Controller
@CrossOrigin(origins="*")
@RequestMapping(value="/inventory", headers="Accept=application/json, text/plain")
public class InventoryController {
	@Autowired
	private InventoryService is;
	
	private ObjectMapper om = new ObjectMapper();
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String addInventory(@RequestBody InventoryItem inv) throws JsonProcessingException {
		return om.writeValueAsString(inv);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String getAll() throws JsonProcessingException {
		return om.writeValueAsString(is.getAll());
	}

}
