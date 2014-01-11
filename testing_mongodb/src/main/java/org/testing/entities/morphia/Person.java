package org.testing.entities.morphia;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Version;
import org.bson.types.ObjectId;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: daniel
 * Date: 10/23/13
 * Time: 7:31 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity("persons")
public class Person {

    private String firstName;
    private String lastName;
    @Id
    private ObjectId oid;
    private Date birthDate;
    private Boolean gender;
    @Embedded
    private Identification identification;
    @Version
    private Long v;

    public Person(String firstName, String lastName, Date birthDate, Boolean gender, Identification identification) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.identification = identification;
    }

    public Person() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
