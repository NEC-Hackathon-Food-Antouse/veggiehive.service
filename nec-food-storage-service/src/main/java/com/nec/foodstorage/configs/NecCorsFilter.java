package com.nec.foodstorage.configs;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class NecCorsFilter implements Filter {

	public NecCorsFilter() {
		// Do nothing
	}

	public void destroy() {
		// Do nothing
	}

	public void doFilter(ServletRequest sRequest, ServletResponse sResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) sRequest;
		((HttpServletResponse) sResponse).addHeader("Access-Control-Allow-Origin", "*");
		((HttpServletResponse) sResponse).setHeader("Access-Control-Max-Age", "3600");
		((HttpServletResponse) sResponse).setHeader("Access-Control-Allow-Headers", "*"); // authorization
		((HttpServletResponse) sResponse).setHeader("Access-Control-Allow-Credentials", "true");
		((HttpServletResponse) sResponse).addHeader("Access-Control-Allow-Methods",
				"OPTIONS,GET, HEAD, PUT, POST, DELETE");
		chain.doFilter(request, sResponse);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// Do nothing
	}

}
