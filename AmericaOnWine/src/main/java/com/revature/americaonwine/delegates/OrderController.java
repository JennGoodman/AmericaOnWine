package com.revature.americaonwine.delegates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.americaonwine.services.TransactionService;

@Controller
@CrossOrigin(origins="*")
@RequestMapping(value="/orderno", headers="Accept=application/json, text/plain")
public class OrderController {
	@Autowired
	private TransactionService ts;
	
	@RequestMapping(method=RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public String maxOrderNumber() throws JsonProcessingException {
		return Integer.toString(ts.getMax());
	}

}
