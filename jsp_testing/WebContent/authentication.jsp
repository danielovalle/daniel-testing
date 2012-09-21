<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.*"%>	
<%@page import="com.ford.owner.consumer.b2cprofile.authentication.*"%>
<%@page import="com.ford.owner.consumer.b2cprofile.bo.*"%>
		
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	
		try {
			
			ConsumerB2CProfileAuthenticationBF authenticationService = new ConsumerB2CProfileAuthenticationBF();
			Map<String, Object> authResponse = authenticationService.authenticateConsumer("cdrmigrationtest01@ford.com", "password", "");

			session.setAttribute("userData", authResponse);
			session.setAttribute("owner", authResponse);
			
			List<VehicleBO> vehicles = (List<VehicleBO>) authResponse.get("vehicle");
			for (VehicleBO v : vehicles) {
				out.println("VIN: " + v.getVin());
				out.println("<br/>");
			}

			OwnerProfileBO owner = (OwnerProfileBO) authResponse.get("owner");
			session.setAttribute("owner", owner);
			
			//out.println(owner.getConsumerID());
			//out.println(owner.getUserName());

		} catch (Exception e) {

		}
	
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "One");
		map.put("2", "Two");
		map.put("3", "Three");
		request.setAttribute("map", map);
		
	%>
	
	<c:out value="${map['2']}"/>
	<p>${sessionScope.owner.userName}</p>
	<p>${sessionScope.userData['owner'].userName}</p>

</body>
</html>