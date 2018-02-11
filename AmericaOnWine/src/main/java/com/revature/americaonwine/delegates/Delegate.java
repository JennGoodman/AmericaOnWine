package com.revature.americaonwine.delegates;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Delegate {

	public void process(HttpServletRequest req, HttpServletResponse resp);
}
