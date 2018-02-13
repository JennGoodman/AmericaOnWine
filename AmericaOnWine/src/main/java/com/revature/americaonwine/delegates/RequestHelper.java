package com.revature.americaonwine.delegates;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class RequestHelper implements Delegate {

	private Logger log = Logger.getLogger(RequestHelper.class);
	private LoginDelegate ld = new LoginDelegate();
	private RetailerDelegate rd = new RetailerDelegate();
	
	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) {
		String path = req.getRequestURI().substring(req.getContextPath().length());
		
		addCorsHeaders(req.getRequestURI(), resp);
		if (req.getMethod() == "POST" || req.getMethod() == "PUT" || req.getMethod() == "GET")
			switch (path){
			case "retailer": 
				rd.sendRetailerItems(req, resp);
				break;
			case "login":
				ld.process(req, resp);
				break;
			default: 
				log.warn("Did not hit any end point!");
				break;
			}
		else {
			log.warn("Got request with method " + req.getMethod()
			+ " We should not be handling this kind of request."); 
		}
	}
	

		private void addCorsHeaders(String reqUri, HttpServletResponse resp) {
			log.trace("adding headers");
			resp.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
			resp.addHeader("Vary", "Origin");
			resp.addHeader("Access-Control-Allow-Credentials", "true");
			resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
			resp.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
			resp.addHeader("Access-Control-Max-Age", "1728000");
			resp.addHeader("Produces", "application/json");	
		}
}
