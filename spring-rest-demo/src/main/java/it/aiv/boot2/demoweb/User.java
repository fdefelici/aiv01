package it.aiv.boot2.demoweb;

public class User {

	private long _id;
	private String _name;
	private String _surname;

	public User(long id, String name, String surname) {
		_id = id;
		_name = name;
		_surname = surname;
	}

	public long getId() {
		return _id;
	}

	public String getName() {
		return _name;
	}

	public String getSurname() {
		return _surname;
	}

}
