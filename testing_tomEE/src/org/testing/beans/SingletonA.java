package org.testing.beans;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class SingletonA
 */
@Singleton(mappedName = "TestSingletonA")
@LocalBean
public class SingletonA implements SingletonARemote, SingletonALocal {

	private Logger LOG = Logger.getLogger("TESTLOG");

	/**
	 * Default constructor.
	 */
	public SingletonA() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void method1() {
		LOG.info("PostConstruct");
	}
	
	public String test1() {
		return "test";
	}

}
