package it.aiv.boot2.demoweb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {

	private List<User> _users = new ArrayList<User>(); 
	
	public void add(User aUser) {
		_users.add(aUser);
	}
	
	public List<User> all() {
		return _users;
	}

	public User findById(long id) {
		for (User user : _users) {
			if (user.getId() == id) return user;
		}
		return null;
	}

	public void remove(User user) {
		_users.remove(user);
	}

	public int size() {
		return _users.size();
	}

	public void removeAll() {
		_users.clear();
	}
}
