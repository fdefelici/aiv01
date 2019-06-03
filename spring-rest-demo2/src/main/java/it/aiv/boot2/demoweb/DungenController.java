package it.aiv.boot2.demoweb;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.aiv.DunFake;

@CrossOrigin(origins = "*")
@RestController
public class DungenController {

	@GetMapping("/dungeon")
	public int[][] generate() {
		DunFake fake = new DunFake();
		return fake.build();
	}
}
