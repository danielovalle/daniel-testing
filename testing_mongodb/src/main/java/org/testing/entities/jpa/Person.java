package org.testing.entities.jpa;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: daniel
 * Date: 10/23/13
 * Time: 7:31 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@NoSql(dataFormat = DataFormatType.MAPPED)
@NamedQuery(name = "persons", query = "SELECT p from Person p")
public class Person implements Serializable {

    private String firstName;
    private String lastName;

    @Id
    @GeneratedValue
    @Field(name = "_id")
    private String id;

    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private Boolean gender;

    @Version
    private Long v;

    public Person(String firstName, String lastName, Date birthDate, Boolean gender) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
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
