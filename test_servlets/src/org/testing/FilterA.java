package org.testing;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class FilterA
 */
@WebFilter(description = "FilterA description", urlPatterns = { "/ServletA" }, initParams = { @WebInitParam(name = "p1", value = "value1", description = "p1 description") })
public class FilterA implements Filter {

	/**
	 * Default constructor.
	 */
	public FilterA() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>");
		out.println("Filter Modification");
		out.println("</title></head>");
		out.println("<body>");

		out.println("<h1>");
		out.println("FilterA content modified");
		out.println("</h1>");

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init filterA ...");
	}

}
