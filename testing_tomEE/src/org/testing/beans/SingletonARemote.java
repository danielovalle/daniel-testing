package org.testing.beans;

import javax.ejb.Remote;

@Remote
public interface SingletonARemote {

	public String test1();
}
