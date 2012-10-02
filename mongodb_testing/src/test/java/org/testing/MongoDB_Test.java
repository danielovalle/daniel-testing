package org.testing;

import java.net.URL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Address;
import model.CSVBeanList;
import model.Customer;
import model.Order;

import org.eclipse.persistence.internal.nosql.adapters.mongo.MongoConnection;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.DB;

public class MongoDB_Test {

	private final static String PERSISTENCE_UNIT = "mongo";
	private static EntityManager em;
	private static EntityManagerFactory emf;

	private static CSVBeanList<Address> addressList;
	private static CSVBeanList<Order> orderList;
	private static CSVBeanList<Customer> customerList;

	private Logger log = LoggerFactory.getLogger(CSVBeanList.class);

	@BeforeClass
	public static void initTest() {

		// Build the EntityManager
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		em = emf.createEntityManager();

		URL url = ClassLoader.getSystemResource("address.csv");
		addressList = new CSVBeanList<Address>(Address.class, url.getPath());
		//url = ClassLoader.getSystemResource("order.csv");
		//orderList = new CSVBeanList<Order>(Order.class, url.getPath());
		url = ClassLoader.getSystemResource("customer.csv");
		customerList = new CSVBeanList<Customer>(Customer.class, url.getPath());

	}

	@AfterClass
	public static void endTest() {

		// close EntityManager and EntityManagerFactory
		em.close();
		emf.close();
	}

	@Before
	public void initDB() {

		// First drop old database.
		em.getTransaction().begin();
		DB db = ((MongoConnection) em
				.unwrap(javax.resource.cci.Connection.class)).getDB();
		db.dropDatabase();
		em.getTransaction().commit();
	}

	@Test
	public void persist() {

		// add customers to mydb
		em.getTransaction().begin();

		for (Customer c : customerList.getBeans()) {
			em.persist(c);
			log.info(c.getId());
		}

		em.getTransaction().commit();
	}

}
