package com.revature.americaonwine.util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.filter.OncePerRequestFilter;

@Controller
public class CorsFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		/*String ip = request.getHeader("X-FORWARDED-FOR");
		if (ip == null || "".equals(ip))
			ip = request.getRemoteAddr();
		if ("0:0:0:0:0:0:0:1".equals(ip))
			ip = "http://localhost:4200";*/
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.addHeader("Vary", "Origin");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		response.addHeader("Access-Control-Allow-Headers",
				"X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.addHeader("Access-Control-Max-Age", "1728000");
		response.addHeader("Produces", "application/json");
		filterChain.doFilter(request, response);

	}

}
