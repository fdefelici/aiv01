package it.aiv.boot2.demoweb;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
	@Autowired
	private MockMvc server;
	@MockBean
	private UserRepository usersMock;
	
	@Test
	public void listTwoUsers_OK() throws UnsupportedEncodingException, Exception {
		List<User> users = new ArrayList<User>();
		users.add(new User(1, "Mario", "Rossi"));
		users.add(new User(2, "Luigi", "Verdi"));
		Mockito.when(usersMock.all()).thenReturn(users);
		
		server.perform(get("/users"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(2)))
			.andExpect(jsonPath("$[0].id", is(1)))
			.andExpect(jsonPath("$[0].name", is("Mario")))
			.andExpect(jsonPath("$[0].surname", is("Rossi")))
			.andExpect(jsonPath("$[1].id", is(2)))
			.andExpect(jsonPath("$[1].name", is("Luigi")))
			.andExpect(jsonPath("$[1].surname", is("Verdi")));
	}
}
