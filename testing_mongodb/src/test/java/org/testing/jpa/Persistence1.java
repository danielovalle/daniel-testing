package org.testing.jpa;

import com.mongodb.DB;
import org.eclipse.persistence.internal.nosql.adapters.mongo.MongoConnection;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testing.entities.jpa.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: daniel
 * Date: 10/23/13
 * Time: 7:58 PM
 * To change this template use File | Settings | File Templates.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Persistence1 {

    private Logger LOG = LoggerFactory.getLogger(Persistence1.class);
    private static EntityManagerFactory factory;
    private static EntityManager em;

    @BeforeClass
    public static void before() {

        try {

            factory = Persistence.createEntityManagerFactory("mongo_db");
            em = factory.createEntityManager();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public static void after() {

        try {

            em.getTransaction().begin();
            DB db = ((MongoConnection) em.unwrap(javax.resource.cci.Connection.class)).getDB();
            db.dropDatabase();
            em.getTransaction().commit();
            em.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void t1() {

        em.getTransaction().begin();
        for (int i = 1; i < 10; i++) {

            em.persist(new Person("Daniel" + 1, "Ovalle" + 1, new Date(), Boolean.TRUE));
        }
        em.getTransaction().commit();
    }

    @Test
    public void t2() {

        em.getTransaction().begin();
        TypedQuery<Person> tq = em.createNamedQuery("persons", Person.class);
        List<Person> r = tq.getResultList();
        for (Person p : r) {

            LOG.info(p.toString());
        }
        em.getTransaction().commit();

    }
}
