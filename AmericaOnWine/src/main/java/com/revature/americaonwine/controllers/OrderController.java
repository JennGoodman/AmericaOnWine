package com.revature.americaonwine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.services.TransactionService;

@RestController
@RequestMapping(value="/orderno", headers="Accept=application/json, text/plain")
public class OrderController {
	@Autowired
	private TransactionService ts;
	
	@RequestMapping(method=RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public String maxOrderNumber() throws JsonProcessingException {
		return Integer.toString(ts.getMax());
	}
	
	@RequestMapping(method=RequestMethod.POST, produces= {"application/json; charset=UTF-8"})
	public String getItemsByInv(@RequestBody InventoryItem inv, ObjectMapper om) throws JsonProcessingException 
	{
		return om.writeValueAsString(ts.getTransByInv(inv));
	}
}
