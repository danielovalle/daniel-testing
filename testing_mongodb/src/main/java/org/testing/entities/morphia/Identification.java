package org.testing.entities.morphia;

import org.testing.entities.IdType;

/**
 * Created with IntelliJ IDEA.
 * User: daniel
 * Date: 10/23/13
 * Time: 7:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Identification {

    private IdType tpe;
    private String value;

    public Identification() {
    }

    public Identification(IdType tpe, String value) {
        this.tpe = tpe;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public IdType getTpe() {
        return tpe;
    }

    public void setTpe(IdType tpe) {
        this.tpe = tpe;
    }
}
