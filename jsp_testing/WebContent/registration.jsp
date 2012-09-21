<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@page import="java.util.*"%>
<%@page import="com.ford.owner.consumer.b2cprofile.*"%>
<%@page import="com.ford.owner.consumer.b2cprofile.bo.*"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	
	// Get request parameters
	String username	= request.getParameter("username");
	String password	= request.getParameter("password");
	String ajaxReq	= request.getParameter("ajax");
	
	// Set controller redirection parameters
	//String redirectURLPrefix = request.getScheme() + "://"	+ ics.GetProperty("domainName", "smrmobile.properties", true);
	String returnPageURI = "home";
	
	// Call the validation controller here
	request.setAttribute("validationConfig", validationConfig);
	//ics.CallElement("smr/mobile/service/util/validation", null);
	out.println("Validation Results - " + request.getAttribute("validationResult"));
	
	// check validation errors
	Map<String, String> validationResult = (request.getAttribute("validationResult") instanceof Map<?, ?>) ? 
		(Map<String, String>) request.getAttribute("validationResult") : null;
	if (validationResult != null && validationResult.size() > 0) {
		session.setAttribute("validationResult", validationResult);
		returnPageURI = "registration";
	} else {
		
		boolean result = register(request);
		
		if (result) {
			
			//send email to user about success registration process
			
		}
	}
	
	%>

	<%!

	// Validation of request parameters or session attributes defined here
	Map<String, Map<String, String>> validationConfig = new HashMap<String, Map<String, String>>() {
		{
			put("request:email", new LinkedHashMap<String, String>() {
				{
					put("NOT_NULL",
							"Invalid information entered. Please enter an email.");
					put("EMAIL_FORMAT", "Minimum of 6 characters.");
				}
			});

			put("request:verifyEmail", new LinkedHashMap<String, String>() {
				{
					put("NOT_NULL",
							"Invalid information entered. Please enter an email.");
					put("EMAIL_FORMAT", "Minimum of 6 characters.");
				}
			});
			
			put("request:password", new LinkedHashMap<String, String>() {
				{
					put("NOT_NULL",
							"Invalid information entered. Please enter a password.");
					put("PASSWORD_FORMAT", "Must be 6-15 characters.");
				}
			});
			
			put("request:verifyPass", new LinkedHashMap<String, String>() {
				{
					put("NOT_NULL",
							"Invalid information entered. Please enter a password.");
					put("PASSWORD_FORMAT", "Must be 6-15 characters.");
				}
			});
			
			put("request:security", new LinkedHashMap<String, String>() {
				{
					put("NOT_NULL",
							"Invalid information entered. Please select a security question.");
				}
			});
			
			put("request:answer", new LinkedHashMap<String, String>() {
				{
					put("NOT_NULL",
							"Invalid information entered. Please enter an answer.");
				}
			});
			
			put("request:vin", new LinkedHashMap<String, String>() {
				{
					put("NOT_NULL",
							"Invalid information entered. Please enter a valid VIN.");
				}
			});
			
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
			
			put("request:streetAddress", new LinkedHashMap<String, String>() {
				{
					put("NOT_NULL",
							"Invalid information entered. Please enter a street.");
				}
			});
			
			put("request:city", new LinkedHashMap<String, String>() {
				{
					put("NOT_NULL",
							"Invalid information entered. Please enter a city.");
					put("CITY_FORMAT",
							"Invalid information entered. Please enter a valid city.");
				}
			});
			
			put("request:state", new LinkedHashMap<String, String>() {
				{
					put("NOT_NULL",
							"Invalid information entered. Please enter a state.");
					put("STATE_FORMAT",
							"Invalid information entered. Please enter a valid state.");
				}
			});
			
			put("request:zip", new LinkedHashMap<String, String>() {
				{
					put("NOT_NULL",
							"Invalid information entered. Please enter a zip.");
					put("ZIP_FORMAT",
							"Invalid information entered. Please enter a valid zip.");
				}
			});
			
			put("request:mobile", new LinkedHashMap<String, String>() {
				{
					put("NOT_NULL",
							"Invalid information entered. Please enter a mobile.");
					put("MOBILE_FORMAT",
							"Invalid information entered. Please enter a valid mobile.");
				}
			});
		}
	};
	
	
	// Registration logic here
	private boolean register(HttpServletRequest req) {
		
		try {
			
			// Facade for registration service
			ConsumerB2CProfileBF registrationBF = new ConsumerB2CProfileBF();
			
			// Build the OwnerProfileBO
			OwnerProfileBO owner = new OwnerProfileBO();
			owner.setEmailID(req.getParameter("email"));
			owner.setUserName(req.getParameter("email"));
			owner.setPassword(req.getParameter("password"));
			owner.setReminderQuestion(req.getParameter("security"));
			owner.setReminderAnswer(req.getParameter("answer"));
			owner.setEmailPrivPref(emailPrivPref);
			
			// Build the VehicleBO
			VehicleBO vehicle = new VehicleBO();
			
			// register
			Map<String, Object> result = registrationBF.register(owner, vehicle);
			
			return true;
			
		} catch (com.ford.it.wscore.exception.WscConsumerSoapException ex) {
			
		}
		
		return false;
	}
	
	%>


</body>
</html>