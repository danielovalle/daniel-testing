<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.*"%>
<%@page import="java.util.regex.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		validationResult = new HashMap<String, String>();

		try {

			validationConfig = (Map<String, Map<String, String>>) request.getAttribute("validationConfig");

		} catch (ClassCastException e) {
			//TODO: Log configuration.
		}

		if (validationConfig != null) {

			request.setAttribute("validationResult",
					validate(request, validationConfig));
		}
	%>

	<%!
	
	// Controller constants declarations
	private static final String REQUEST = "request";
	private static final String SESSION = "session";
	private static final Pattern EMAIL_FORMAT = Pattern.compile(".+@.+\\..+");
	private static final Pattern ZIP_FORMAT = Pattern.compile("^\\d{5}(-\\d{4})?$");
	private static final Pattern PASSWORD_FORMAT = Pattern.compile("^[a-zA-Z0-9@#$% _-]{6,15}$");
	//private static final Pattern FIRSTNAME_FORMAT = Pattern.compile("^[*]{0,25}$");
	//private static final Pattern PASSWORD_FORMAT = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
	//((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})

	// Controller variable declarations
	private Map<String, Map<String, String>> validationConfig;
	private Map<String, String> validationResult;

	// This method validates all the attribute values provided on the validationConfig
	private Map<String, String> validate(HttpServletRequest request, Map<String, Map<String, String>> validationConfig) {

		// loop the list of attribute names to be validated.
		for (String attribute : validationConfig.keySet()) {

			// get the attribute value from the request/session source
			String value = getAttributeValue(request, attribute);

			// loop all the validations for the attribute's value
			for (String validation : validationConfig.get(attribute).keySet()) {

				if (validation.equals("NOT_NULL") && !notNull(value)) {

					addValidationError(attribute, validation);
					break;
				}

				if (validation.equals("EMAIL_FORMAT")
						&& !EMAIL_FORMAT.matcher(value).matches()) {

					addValidationError(attribute, validation);
					break;
				}

				if (validation.equals("ZIP_FORMAT")
						&& !ZIP_FORMAT.matcher(value).matches()) {

					addValidationError(attribute, validation);
					break;
				}

				if (validation.equals("USERNAME_FORMAT") && !usernameFormat(value)) {

					addValidationError(attribute, validation);
					break;
				}

				if (validation.equals("PASSWORD_FORMAT") && !PASSWORD_FORMAT.matcher(value).matches()) {

					addValidationError(attribute, validation);
					break;
				}

				if (validation.equals("FIRSTNAME_FORMAT") && !(value.length() <= 25) ) {

					addValidationError(attribute, validation);
					break;
				}
				
				if (validation.equals("LASTNAME_FORMAT") && !(value.length() <= 50) ) {

					addValidationError(attribute, validation);
					break;
				}
				
				if (validation.equals("CITY_FORMAT") && !(value.length() <= 30) ) {

					addValidationError(attribute, validation);
					break;
				}
				
				if (validation.equals("STATE_FORMAT") && !(value.length() <= 2) ) {

					addValidationError(attribute, validation);
					break;
				}
				
				if (validation.equals("ZIP_FORMAT") && !(value.length() <= 5) ) {

					addValidationError(attribute, validation);
					break;
				}
				
				if (validation.equals("MOBILE_FORMAT") && !(value.length() <= 10) ) {

					addValidationError(attribute, validation);
					break;
				}
			}
		}

		return validationResult;
	}

	/*	
	 *This method extracts the attribute value from the request or session. The notation
	 *of the "attribute" should be: request:attribute or session:attribute
	 *
	 *TODO: This method work for String values, if needed this should be improved to return specific
	 *datatypes.
	 */
	private String getAttributeValue(HttpServletRequest request,
			String attribute) {

		String value = null;
		String[] array = attribute.split(":");

		if (array != null && array.length > 1) {

			if (array[0].equals(REQUEST)) {

				value = request.getParameter(array[1]);

			} else if (array[0].equals(SESSION)) {

				// This should be reviewed to enable datatypes differen than String
				value = request.getSession().getAttribute(array[1]).toString();
			}
		}

		// Check if the value can be trimmed
		value = (value != null) ? value.trim() : null;
		return value;
	}

	// NOT_NULL validation
	private boolean notNull(String value) {

		if (value == null || "".equals(value)) {

			return false;
		}
		return true;
	}

	// PASSWORD_FORMAT validation
	private boolean passwordFormat(String value) {

		if (!value.matches("^\\d{5}(-\\d{4})?$")) {

			return false;
		}
		return true;
	}

	// USERNAME_FORMAT validation
	private boolean usernameFormat(String value) {

		if (!value.matches("^\\d{5}(-\\d{4})?$")) {

			return false;
		}
		return true;
	}

	// Method adds a validation error to validationResult
	private void addValidationError(String attribute, String validation) {
		validationResult.put(attribute,
				validationConfig.get(attribute).get(validation));
	}
	
	%>

</body>
</html>