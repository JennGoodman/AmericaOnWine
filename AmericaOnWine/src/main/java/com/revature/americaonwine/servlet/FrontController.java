package com.revature.americaonwine.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

public class FrontController extends DefaultServlet {

	private static final long serialVersionUID = 5822782615442735209L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String path = req.getRequestURI().substring(req.getContextPath().length() + 1);
		if (path.contains("static")) {
			super.doGet(req, resp);
		}
		else {
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
	}
	
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
	}
	
	
}
