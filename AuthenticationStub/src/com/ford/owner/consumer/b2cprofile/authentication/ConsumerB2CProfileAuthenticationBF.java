package com.ford.owner.consumer.b2cprofile.authentication;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import com.ford.owner.consumer.b2cprofile.bo.OwnerProfileBO;
import com.ford.owner.consumer.b2cprofile.bo.VehicleBO;

public class ConsumerB2CProfileAuthenticationBF {

	 public Hashtable authenticateConsumer(String userName, String userPassword, String sC)
	  {

	    Hashtable htAuthenticateConsumer = new Hashtable();

	    OwnerProfileBO owner = new OwnerProfileBO();
	    owner.setUserName(userName);
	    owner.setPassword(userPassword);
	    
	    
	    List vehicleList = new ArrayList();

	    VehicleBO vehicleProfile = new VehicleBO();
	    vehicleProfile.setMake("Ford");
	    vehicleProfile.setModel("Focus");
	    vehicleProfile.setYear("1997");
	    
	    
	    vehicleList.add(vehicleProfile);

	    htAuthenticateConsumer.put("owner", owner);
	    htAuthenticateConsumer.put("vehicle", vehicleList);
	    return htAuthenticateConsumer;
	  }
}
