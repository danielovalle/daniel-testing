package org.testing;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.testing.beans.ServiceA;
import org.testing.beans.SingletonALocal;
import org.testing.entities.EntityA;

/**
 * Servlet implementation class ServletA
 */
@WebServlet("/ServletA")
public class ServletA extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private ServiceA serviceA;
	
	@EJB
	private SingletonALocal singA;

	@Inject
	private EntityA entityA;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletA() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		response.getWriter().println("<h1>Hey Daniel</h1>");
		response.getWriter().println(
				"<h1>" + request.getParameter("lastName") + "</h1>");

		response.getWriter().println("<h2>" + serviceA.sayHello() + "</h2>");
		response.getWriter().println("<h2>" + entityA.getName() + "</h2>");
		
		response.getWriter().println("<h2>" + singA.test1() + "</h2>");
	}

}
