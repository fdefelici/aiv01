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
	
	@PostMapping("/users")
	public Object createUser(@RequestBody UserJson aUser) {
		long id = System.currentTimeMillis();
		
		String name = aUser.name;
		String surname = aUser.surname;
		if (name == null || name.isEmpty()) {
			ErrorJson error = new ErrorJson();
			error.message = "Missing name";
			return ResponseEntity.badRequest().body(error); //alternative for: new ResponseEntity<ErrorJson>(error, HttpStatus.BAD_REQUEST);
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
		return ResponseEntity.ok(json); //alternative for: new ResponseEntity<UserJson>(json, HttpStatus.OK);
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
