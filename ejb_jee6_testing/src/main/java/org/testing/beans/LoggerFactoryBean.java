package org.testing.beans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Session Bean implementation class LoggerFactory
 */
@Singleton
public class LoggerFactoryBean {

	private Log log = LogFactory.getLog(LoggerFactoryBean.class);
	private String creationDate;

	/**
	 * Default constructor.
	 */
	public LoggerFactoryBean() {
		System.out.println("LoggerFactory constructor call");
	}

	@PostConstruct
	public void init() {
		System.out.println("Initialize singleton");
		creationDate = new Date().toString();
	}

	@PreDestroy
	public void shutdown() {
		System.out.println("Shutting down singleton");
	}

	public String getDate() {
		return creationDate;
	}

	public String sampleMethod() {
		return "Singleton provided value";
	}

	@Produces
	Log createLogger(InjectionPoint injectionPoint) {
		String name = injectionPoint.getMember().getDeclaringClass().getName();
		log.debug("creating Log instance for injecting into " + name);
		return LogFactory.getLog(name);
	}

}
