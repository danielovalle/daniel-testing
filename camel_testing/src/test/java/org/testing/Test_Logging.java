package org.testing;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test_Logging {

	Logger logger = LoggerFactory.getLogger(Test_Logging.class);

	@Test
	public void t1() {

		logger.info("info Hello World");
		logger.debug("debug Hello world");
		logger.error("error Hello world");
		logger.trace("trace Hello world");
		logger.warn("warn Hello world");
	}

}
