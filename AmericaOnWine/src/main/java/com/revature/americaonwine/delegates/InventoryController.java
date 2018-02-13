package com.revature.americaonwine.delegates;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.services.InventoryService;

@Controller
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping(value="/inventory")
public class InventoryController {
	@Autowired
	private InventoryService is;
	
	private ObjectMapper om = new ObjectMapper();
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public InventoryItem addInventory(@RequestBody InventoryItem inv, HttpSession session) throws JSONProcessingException {
		return inv;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<InventoryItem> getAll(HttpSession session) throws JSONProcessingException {
		
	}

}
