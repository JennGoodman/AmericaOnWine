package com.revature.americaonwine.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.americaonwine.beans.Transaction;
import com.revature.americaonwine.beans.User;
import com.revature.americaonwine.services.CheckoutService;

@RestController
@RequestMapping(value="/transaction", headers="Accept=application/json, text/plain")
public class CheckoutController {
	@Autowired
	private CheckoutService cs;
	
	@RequestMapping(method=RequestMethod.POST)
	public String addTransaction(@RequestBody Transaction fromWeb, ObjectMapper om, HttpSession session) throws JsonProcessingException {
		
		Transaction fromDB = cs.newTransaction(fromWeb);
		
		if(fromDB != null) {
			return om.writeValueAsString(fromDB);
		}else {
			return null;
		}
		
	}
	
	@RequestMapping(method=RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public String getTransaction(ObjectMapper om, HttpSession session) throws JsonProcessingException {
		User u = (User) session.getAttribute("user");
		List<Transaction> fromDB = cs.getTransactionsForUser(u);
		
		if(fromDB != null) {
			return om.writeValueAsString(fromDB);
		}else {
			return null;
		}

	}
	
	@RequestMapping(method=RequestMethod.PUT, produces= {"application/json; charset=UTF-8"})
	public Transaction updateTransaction(@RequestBody Transaction t, HttpSession session) throws JsonProcessingException 
	{
		User u = (User) session.getAttribute("user");
		if (u == null)
			return null;
		return cs.updateTransaction(t);
	}
}
