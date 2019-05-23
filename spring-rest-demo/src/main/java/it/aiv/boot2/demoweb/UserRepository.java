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
}
