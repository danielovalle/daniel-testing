package core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test1 {
	
	Logger logger = LoggerFactory.getLogger(Test1.class);

	private int a, b;

	Test1(int i, int j) {
		a = i;
		b = j;
	}

	void meth(Test1 o) {
		o.a *= 2;
		o.b /= 2;
	}

	int fact(int n) {
		int result;

		if (n == 1)
			return 1;
		result = fact(n - 1) * n;
		return result;
	}

	public String toString() {
		return String.format("Test1[a: %s, b: %s]", a, b);
	}

	public void finalize() {
		logger.warn("Finalized call");
	}
}
