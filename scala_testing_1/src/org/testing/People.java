package org.testing;

public class People {

	public People(Person person) {
		super();
		this.person = person;
	}

	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getValue() {
		return this.person;
	}

}
