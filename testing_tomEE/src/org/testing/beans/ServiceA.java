package org.testing.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ServiceA
 */
@Stateless(mappedName = "ServiceA")
@LocalBean
public class ServiceA implements ServiceAInterface {

    /**
     * Default constructor. 
     */
    public ServiceA() {
        // TODO Auto-generated constructor stub
    }
    
    /* (non-Javadoc)
	 * @see org.testing.beans.ServiceAInterface#sayHello()
	 */
    @Override
	public String sayHello() {
    	
    	return Messages.getString("ServiceA.0"); //$NON-NLS-1$
    }
    

}
