package org.testing.beans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Session Bean implementation class LoggerFactory
 */
@Singleton
public class LoggerFactoryBean {

	private Logger log = LoggerFactory.getLogger(LoggerFactoryBean.class);
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
	Logger createLogger(InjectionPoint injectionPoint) {
		String name = injectionPoint.getMember().getDeclaringClass().getName();
		log.debug("creating Log instance for injecting into " + name);
		return LoggerFactory.getLogger(name);
	}

}
