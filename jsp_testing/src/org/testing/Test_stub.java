package org.testing;

import static org.junit.Assert.*;

import java.util.Hashtable;

import org.junit.Test;

import com.ford.owner.consumer.b2cprofile.authentication.ConsumerB2CProfileAuthenticationBF;

public class Test_stub {

	@Test
	public void testAuthenticateConsumer() {
		//fail("Not yet implemented");
		
		ConsumerB2CProfileAuthenticationBF auth = new ConsumerB2CProfileAuthenticationBF();
		
		Hashtable tmp = auth.authenticateConsumer("", "", "");
		
		System.out.println(tmp);
	}

}
