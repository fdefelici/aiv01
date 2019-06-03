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
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof User)) return false;
		User other = (User) obj;
		return getId() == other._id;
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

	public void setName(String name) {
		_name = name;
	}

	public void setSurname(String surname) {
		_surname = surname;
	}

}
