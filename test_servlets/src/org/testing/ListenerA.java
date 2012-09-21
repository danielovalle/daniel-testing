package org.testing;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ListenerA
 *
 */
@WebListener
public class ListenerA implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ListenerA() {
        // TODO Auto-generated constructor stub
    	System.out.println("ListenerA ...");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	System.out.println("contextInitialized ...");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	System.out.println("contextDestroyed ...");
    }
	
}
