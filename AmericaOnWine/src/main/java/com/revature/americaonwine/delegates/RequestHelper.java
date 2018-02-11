package com.revature.americaonwine.delegates;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class RequestHelper implements Delegate {

	private Logger log = Logger.getLogger(RequestHelper.class);
	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) {
		String path = req.getRequestURI().substring(req.getContextPath().length() + 1);
		if (req.getMethod() == "POST" || req.getMethod() == "PUT" || req.getMethod() == "GET")
			switch (path){
			case "retailer/home": break;
			default: 
				log.warn("Did not hit any end point!");
				break;
			}
		else {
			log.warn("Got request with method " + req.getMethod()
			+ " We should not be handling this kind of request."); 
		}
	}
	

}
