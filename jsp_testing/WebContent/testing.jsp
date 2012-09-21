<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@page import="java.util.*"%>
	<%@page import="com.ford.owner.consumer.b2cprofile.authentication.ConsumerB2CProfileAuthenticationBF"%>

	<%
		Date passwordLocked = new Date();
		session.setAttribute("passwordLocked", passwordLocked);
	%>
	<br />
	<%
		Date passwordLocked2 = null;
		Date passwordLocked3 = null;

		passwordLocked2 = (session.getAttribute("passwordLocked") instanceof Date) ? (Date) session
				.getAttribute("passwordLocked") : null;
		out.println("locked time: " + passwordLocked2);
	%>
	<br />
	<%
		Calendar cal = Calendar.getInstance();
		cal.setTime(passwordLocked2);
		cal.add(Calendar.MINUTE, 5);
		out.println("unlock time: " + cal.getTime());
	%>
	<br />
	<%
		Date now = new Date();
		out.println("now: " + now);
		out.println("<br/>");
		out.println(cal.getTime().before(now));
	%>
	<br />
	<%

		out.println("isPasswordLocked: " + isPasswordLocked(request));
	%>	
	
	<%
	
		request.setAttribute("validationResult", validationResult);
	
		Map<String, String> validationResult1 = (request.getAttribute("validationResult") instanceof Map<?, ?>) ? 
			(Map<String, String>) request.getAttribute("validationResult") : null;
	
		if (validationResult1 != null && validationResult.size() > 0) {
			session.setAttribute("validationResult", validationResult);
		}
		
		boolean tmp = authenticate(request, "daniel", "ovalle");
	%>
	
	<%
	
		String ajaxReq	= request.getParameter("ajax");
		String returnPageURI = (ajaxReq != null && ajaxReq.equals("true")) ? "home&ajax" : "home";
		
		//if (ajaxReq == null && !ajaxReq.equals("true")) {
			//request.setAttribute("redirectURI", redirectURLPrefix + returnPageURI);
		//}
	%>
	
	<%
	
		Integer step = (request.getParameter("step") instanceof String) ? Integer.parseInt(request.getParameter("step")) : 1;
		out.println(step);
	%>
	
		<br/>
		<c:if test="${param.ajax == true}">
			{"status":"success","url":"<%= returnPageURI%>"}
		</c:if>

		<br/>
		<!-- Test JSTL for login button -->
		<c:if test="${sessionScope.ProperLogin != 'Y'}">
			<a href="login">LOG IN</a>
		</c:if>
		<c:if test="${sessionScope.ProperLogin == 'Y'}">
			<a href="login">LOG OUT</a>
		</c:if>
	
	<%!
	
		private ConsumerB2CProfileAuthenticationBF authService = new ConsumerB2CProfileAuthenticationBF();
		private final String EXCEPTION_INVALID_PASSWORD = "Invalid Password";
	
		// Authentication logic here
		private boolean authenticate(HttpServletRequest req, String username, String password) {
			
			HttpSession session = req.getSession();
		
			try {
				
				Hashtable result = authService.authenticateConsumer(username, password, "");
				
				//TODO: Logic to define if the password provided is invalid and set a session
				// attribute to control the number of invalid passwords allowed.
			
				if (!result.isEmpty()) {
					return true;
				}
				
			} catch (com.ford.it.wscore.exception.WscConsumerSoapException ex) {
				
				// code to check the exception String and identify if is an invalid password
				String authenticationError = ex.getMessage();
				
				if (authenticationError != null && authenticationError.equals(EXCEPTION_INVALID_PASSWORD)) {
					
					Integer invalidPasswordCounter = (session.getAttribute("invalidPasswordCounter") instanceof Integer) ? 
							(Integer) session.getAttribute("invalidPasswordCounter") : 0;
					invalidPasswordCounter++;
					if (invalidPasswordCounter > 2) {
						session.setAttribute("passwordLocked", new Date());
					}
					session.setAttribute("invalidPasswordCounter", invalidPasswordCounter);
				}
			}
			
			return false;
		}
	
		// Method checks if the authentication is locked because invalid password tries
		private boolean isPasswordLocked(HttpServletRequest req) {
		
			HttpSession session = req.getSession();
			Date passwordLocked = (session.getAttribute("passwordLocked") instanceof Date) ? (Date) session.getAttribute("passwordLocked") : null;
			if (passwordLocked != null) {
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(passwordLocked);
				cal.add(Calendar.MINUTE, 15);
				return cal.getTime().before(new Date());
			}
			return false;
		}
	
		// Validation of request parameters or session attributes defined here
		Map<String, Map<String, String>> validationConfig = new HashMap<String, Map<String, String>>() {
			{
				put("request:username", new LinkedHashMap<String, String>() {
					{
						put("NOT_NULL", "Invalid information entered. Please enter a User Name and Password.");
					}
				});
				
					put("request:password", new HashMap<String, String>() {
					{
						put("NOT_NULL", "Invalid information entered. Please enter a User Name and Password.");
					}
				});
			}
		};
		
		// Validation of request parameters or session attributes defined here
		Map<String, String> validationResult = new HashMap<String, String>() {
			{
				put("key", "value");
				put("key2", "value2");
			}
		};
		
	%>

</body>
</html>