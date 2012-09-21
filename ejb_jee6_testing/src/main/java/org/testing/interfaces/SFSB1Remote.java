package org.testing.interfaces;

import javax.ejb.Remote;

@Remote
public interface SFSB1Remote {

	public String remoteMethod1(String parameter);
}
