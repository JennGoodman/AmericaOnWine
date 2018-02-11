package com.revature.americaonwine.delegates;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.americaonwine.beans.InventoryItem;
import com.revature.americaonwine.beans.User;
import com.revature.americaonwine.services.HibernateService;
import com.revature.americaonwine.services.Service;

public class RetailerDelegate {

	private Service hs = new HibernateService();
	private ObjectMapper om = new ObjectMapper();
	
	public void sendRetailerItems(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
		List<InventoryItem> items = new ArrayList<InventoryItem>();
		HttpSession session = req.getSession();
		User retailer = (User) session.getAttribute("user");
		items.addAll(hs.getInventoryForUser(retailer));
		resp.getWriter().write(om.writeValueAsString(items));;
	}
}
