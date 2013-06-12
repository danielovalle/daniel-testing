package core;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test1test {

	Logger logger = LoggerFactory.getLogger(Test1test.class);

	/**
	 * Used on t3()
	 */
	private void testFinalize() {

		Test1 o = new Test1(2, 4);

	}

	@Test
	public void t1() {

		Test1 o = new Test1(2, 4);
		logger.info(o.toString());

		o.meth(o);
		logger.info(o.toString());
	}

	@Test
	public void t2() {

		Test1 o = new Test1(2, 4);
		logger.info(String.valueOf(o.fact(5)));

	}

	// Check the GC calling the finalize method from an object
	@Test
	public void t3() {

		logger.info("start");

		testFinalize();
		System.gc();

		logger.info("done");

	}
}
