package org.testing;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;
import org.testing.interfaces.SFSB1Remote;

public class TestSFSB1 {

	private SFSB1Remote remote;
	private final String SFSB1_JNDI = "ejb:/ejb_jee6_testing//Sfsb1Bean!org.testing.interfaces.SFSB1Remote?stateful";

	@Before
	public void before() {

		try {
			Context context = new InitialContext();
			// Context context = new InitialContext(jndiProperties);
			remote = (SFSB1Remote) context.lookup(SFSB1_JNDI);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test1() {
		System.out.println("*** TEST OUTPUT ***");
		String response = remote.remoteMethod1("daniel ovalle");
		System.out.println(response);
	}

}
