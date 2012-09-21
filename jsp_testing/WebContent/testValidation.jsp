<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@page import="java.util.*"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		// Get request parameters
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String ajaxReq = request.getParameter("ajax");
		


		// Call the validation controller here
		request.setAttribute("validationConfig", validationConfig);
		
		//ics.CallElement("smr/mobile/service/util/validation", null);
		%>
		<jsp:include page="validation.jsp"/>
		<%

		// check validation errors
		Map<String, String> validationResult = (request.getAttribute("validationResult") instanceof Map<?, ?>) ? 
				(Map<String, String>) request.getAttribute("validationResult") : null;
				
		out.println("Validation Results: " + validationResult);
		//out.println("<br/>");
		//out.println("password: " + password);

	%>

	<%!

	// Validation of request parameters or session attributes defined here
	Map<String, Map<String, String>> validationConfig = new HashMap<String, Map<String, String>>() {
		{
			
			put("request:username", new LinkedHashMap<String, String>() {
				{
					put("NOT_NULL",
							"Invalid information entered. Please enter a User Name and Password.");
				}
			});

			/*
			put("request:password", new LinkedHashMap<String, String>() {
				{
					put("NOT_NULL",
							"Invalid information entered. Please enter a User Name and Password.");
					put("PASSWORD_FORMAT", "Must be 6-15 characters.");
				}
			});*/
			
			/*
			put("request:email", new LinkedHashMap<String, String>() {
				{
					put("NOT_NULL",
							"Invalid information entered. Please enter a User Name and Password.");
					put("EMAIL_FORMAT",	"Minimum of 6 characters.");
				}
			});*/
			
/* 			put("request:vim", new LinkedHashMap<String, String>() {
				{
					put("NOT_NULL",
							"Invalid vim entered. Please enter a valid VIM value.");
				}
			}); */
			
			put("request:firstName", new LinkedHashMap<String, String>() {
				{
					put("NOT_NULL",
							"Invalid information entered. Please enter a first name.");
					put("FIRSTNAME_FORMAT",
							"Invalid information entered. Please enter a valid first name.");
				}
			});
			
			put("request:lastName", new LinkedHashMap<String, String>() {
				{
					put("NOT_NULL",
							"Invalid information entered. Please enter a last name.");
					put("LASTNAME_FORMAT",
							"Invalid information entered. Please enter a valid last name.");
				}
			});
		}
	};

	%>

</body>
</html>