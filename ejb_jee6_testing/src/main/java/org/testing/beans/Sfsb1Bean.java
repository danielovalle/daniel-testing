package org.testing.beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;

import org.testing.interfaces.SFSB1Local;
import org.testing.interfaces.SFSB1Remote;

/**
 * Session Bean implementation class SFSB1
 */
@Stateful
public class Sfsb1Bean implements SFSB1Remote, SFSB1Local {

	@EJB
	LoggerFactoryBean lfb;

	public Sfsb1Bean() {
		System.out.println("Sfsb1Bean constructor");
	}

	@PostConstruct
	private void postConstructor() {
		System.out.println("Sfsb1Bean @PostConstruct");
		System.out.println(lfb.sampleMethod());
	}

	@Override
	public String localMethod1(String parameter) {

		return "Local Hello " + parameter;
	}

	@Override
	public String remoteMethod1(String parameter) {

		return "Remote Hello " + parameter;
	}

}
