package org.testing;

import java.util.HashMap;
import java.util.Map;

public class ValidationForm {

	/* Errors codes */
	public static final Integer ERR_EMAIL_ENTER = 1;
	public static final Integer ERR_EMAIL_INVALID = 2;
	public static final Integer ERR_ZIPCODE_ENTER = 3;
	public static final Integer ERR_ZIPCODE_INVALID = 4;
	public static final Integer ERR_ZIPCODE_NUM_ONLY = 5;

	/* The properties */
	String email = "";
	String zipcode = "";

	// Holds error messages for the properties
	Map<String, Integer> errorCodes = new HashMap<String, Integer>();

	// Maps error codes to textual messages.
	// This map must be supplied by the object that instantiated this bean.
	Map<Integer, String> msgMap;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.trim();
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode.trim();
	}

	public void setErrorMessages(Map<Integer, String> msgMap) {
		this.msgMap = msgMap;
	}

	public String getErrorMessage(String propName) {

		Integer code = (Integer) (errorCodes.get(propName));

		if (code == null) {

			return "";

		} else if (msgMap != null) {

			String msg = (String) msgMap.get(code);

			if (msg != null) {

				return msg;
			}
		}
		return "Error";
	}

	/* Form validation and processing */
	public boolean isValid() {

		// Clear all errors
		errorCodes.clear();

		// Validate email
		if (email.length() == 0) {

			errorCodes.put("email", ERR_EMAIL_ENTER);

		} else if (!email.matches(".+@.+\\..+")) {

			errorCodes.put("email", ERR_EMAIL_INVALID);
		}

		// Validate zipcode
		if (zipcode.length() == 0) {

			errorCodes.put("zipcode", ERR_ZIPCODE_ENTER);

		} else if (zipcode.length() != 5) {

			errorCodes.put("zipcode", ERR_ZIPCODE_INVALID);

		} else {

			try {

				int i = Integer.parseInt(zipcode);

			} catch (NumberFormatException e) {

				errorCodes.put("zipcode", ERR_ZIPCODE_NUM_ONLY);
			}
		}

		// If no errors, form is valid
		return errorCodes.size() == 0;
	}

	public boolean process() {

		if (!isValid()) {

			return false;
		}

		// Process form...

		// Clear the form
		email = "";
		zipcode = "";
		errorCodes.clear();
		return true;

	}

}
