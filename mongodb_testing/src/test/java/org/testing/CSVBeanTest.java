package org.testing;

import java.net.URL;

import model.Address;
import model.CSVBeanList;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CSVBeanTest {

	private static Logger log = LoggerFactory.getLogger(CSVBeanList.class);
	private static CSVBeanList<Address> addressList;

	@BeforeClass
	public static void initTest() {

		URL url = ClassLoader.getSystemResource("address.csv");
		addressList = new CSVBeanList<Address>(Address.class, url.getPath());

	}

	@Test
	public void t1() {

		for (Address a : addressList.getBeans()) {
			log.info(printBean(a));
		}
	}

	private String printBean(Object o) {
		return ReflectionToStringBuilder.toString(o,
				ToStringStyle.DEFAULT_STYLE);
	}

}
