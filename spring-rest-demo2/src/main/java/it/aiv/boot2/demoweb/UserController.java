package it.aiv.boot2.demoweb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository users;
	
	@DeleteMapping("/users")
	public Object removeAllUsers() {
		int size = users.size();
		users.removeAll();
		return ResponseEntity.ok(size);
	}
	
	
	@DeleteMapping("/users/{id}")
	public Object removeUser(@PathVariable long id) {
		User user = users.findById(id);
		if (user == null) return new ResponseEntity<ErrorJson>(new ErrorJson(), HttpStatus.NOT_FOUND);
		
		users.remove(user);
		
		UserJson json = new UserJson();
		json.id = user.getId();
		json.name = user.getName();
		json.surname = user.getSurname();
		return ResponseEntity.ok(json);
	}
	
	@PutMapping("/users/{id}")
	public Object updateUserById(@PathVariable long id, @RequestBody UserJson data) {
		User user = users.findById(id);
		if (user == null) return new ResponseEntity<ErrorJson>(new ErrorJson(), HttpStatus.NOT_FOUND);
		
		user.setName(data.name);
		user.setSurname(data.surname);
			
		UserJson json = new UserJson();
		json.id = user.getId();
		json.name = user.getName();
		json.surname = user.getSurname();
		return ResponseEntity.ok(json);
	}
	
	
	@GetMapping("/users/{id}")
	public Object retrieveUserById(@PathVariable long id) {
		User user = users.findById(id);
		//If user not found then return error
		if (user == null) return new ResponseEntity<ErrorJson>(new ErrorJson(), HttpStatus.NOT_FOUND);
		//else return the user
		UserJson json = new UserJson();
		json.id = user.getId();
		json.name = user.getName();
		json.surname = user.getSurname();
		return ResponseEntity.ok(json);
	}
	
	@PostMapping("/users")
	public Object createUser(@RequestBody UserJson aUser) {
		long id = System.currentTimeMillis();
		
		String name = aUser.name;
		String surname = aUser.surname;
		if (name == null || name.isEmpty()) {
			ErrorJson error = new ErrorJson();
			error.message = "Missing name";
			// new ResponseEntity<ErrorJson>(error, HttpStatus.BAD_REQUEST);
			return ResponseEntity.badRequest().body(error); 
		}
		
		if (surname == null || surname.isEmpty()) {
			ErrorJson error = new ErrorJson();
			error.message = "Missing surname";
			return ResponseEntity.badRequest().body(error); 
		}
		User newUser = new User(id, name, surname);
		users.add(newUser);
		
		UserJson json = new UserJson();
		json.id = newUser.getId();
		json.name = newUser.getName();
		json.surname = newUser.getSurname();
		return ResponseEntity.ok(json); //new ResponseEntity<UserJson>(json, HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public List<UserJson> allUsers() {
		List<UserJson> result = new ArrayList<UserJson>();
		for (User each : users.all()) {
			UserJson json = new UserJson();
			json.id = each.getId();
			json.name = each.getName();
			json.surname = each.getSurname();
			result.add(json);
		}
		return result;
	}

	
}
