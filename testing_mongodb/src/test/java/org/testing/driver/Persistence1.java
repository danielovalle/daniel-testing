package org.testing.driver;

import com.mongodb.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;

public class Persistence1 {

    //LOG output
    private static Logger LOG = LoggerFactory.getLogger(Persistence1.class);

    private static MongoClient client;
    private static DB db;
    private static DBCollection people;

    @BeforeClass
    public static void init() {

        try {

            client = new MongoClient();
            db = client.getDB("school");
            people = db.getCollection("people");

        } catch (UnknownHostException e) {
            LOG.error(e.toString());
        }

    }

    // insert objects and demonstrates the ID field creation
    @Test
    public void t1() {


        DBObject doc = new BasicDBObject("name", "Andrew Erlichson").append("company", "10gen");

        LOG.info(doc.toString());

        try {
            people.insert(doc);      // first insert
            LOG.info(doc.toString());

            doc.removeField("_id");  // remove the "_id" field
            LOG.info(doc.toString());

            people.insert(doc);      // second insert
            LOG.info(doc.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
