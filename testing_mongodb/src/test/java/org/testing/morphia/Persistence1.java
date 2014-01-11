package org.testing.morphia;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.query.Query;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.testing.entities.IdType;
import org.testing.entities.morphia.Identification;
import org.testing.entities.morphia.Person;

import java.util.Date;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: daniel
 * Date: 10/23/13
 * Time: 7:58 PM
 * To change this template use File | Settings | File Templates.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Persistence1 {

    private Logger LOG = Logger.getLogger("Test1");
    private static MongoClient client;
    private static Datastore dataStore;

    @BeforeClass
    public static void before() {

        try {
            client = new MongoClient(new ServerAddress("localhost", 27017));

            if (client != null)
                dataStore = new Morphia().map(Person.class).createDatastore(client, "morphia_test");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public static void after() {

        dataStore.delete(dataStore.createQuery(Person.class));
    }

    @Test
    public void t1() {

        for (int i = 1; i < 10; i++) {

            dataStore.save(new Person(
                    "Daniel" + i,
                    "Ovalle" + i,
                    new Date(),
                    Boolean.TRUE, new Identification(IdType.CI, "1721013306")
            ));
        }
    }

    @Test
    public void t2() {

        Query<Person> q = dataStore.createQuery(Person.class);
        for (Person p : q.asList()) {
            LOG.info(p.toString());
            //p.setFirstName("Juan Felipe");
            //dataStore.save(p);
            //LOG.info(p.toString());
        }
    }
}
