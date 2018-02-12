package com.revature.americaonwine.delegates;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.americaonwine.beans.User;
import com.revature.americaonwine.data.UserDao;
import com.revature.americaonwine.data.UserHibernate;
import com.revature.americaonwine.util.LogUtil;

public class LoginDelegate implements Delegate {

	private UserDao ud = new UserHibernate();
	private ObjectMapper om = new ObjectMapper();
	private Logger log = Logger.getLogger(LoginDelegate.class);
	
	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) {
		String path = req.getRequestURI().substring(req.getContextPath().length() + 1);
		if (req.getMethod()== "POST") {
			HttpSession session = req.getSession();
			try {
				BufferedReader br = req.getReader();
				StringBuilder sb = new StringBuilder();
				while (br.ready()) {
					sb.append(br.readLine());
				}
				//final ObjectNode node = om.readValue(sb.toString(), ObjectNode.class);
				JsonNode rootNode = om.readTree(sb.toString());
				User user = ud.getUserByUsername(rootNode.get("username").asText());
				log.trace("[+++] Got user from db  " + user);
				session.setAttribute("user", user);
				resp.getWriter().write(om.writeValueAsString(om.writeValueAsString(user)));
				
			} catch (IOException e) {
				LogUtil.logException(e);
			}
		}
	}

}
