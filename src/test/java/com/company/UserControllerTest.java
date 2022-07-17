package com.company;

import com.company.model.*;
import com.company.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = DemoApplication.class)
public class UserControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	UserService userServiceMock;

	@Test
	@SuppressWarnings({ "rawtypes", "serial" })
	public void shouldReturnUsers() throws Exception {

		User inputUser = User.builder().name("Demo").build();
		List<User> inputUsers = new ArrayList<User>() {{ add(inputUser); }};
		Response<User> inputResponse = Response.<User>builder().count(1L).items(inputUsers).build();

		when(userServiceMock.getUsers()).thenReturn(inputResponse);

		ResponseEntity<Response> entity = restTemplate.getForEntity("/api/v1/users", Response.class);
		Map user = Map.class.cast(entity.getBody().getItems().get(0));

		assertEquals(HttpStatus.OK, entity.getStatusCode());
		assertEquals(1, entity.getBody().getCount());
		assertEquals(inputUser.getName(), user.get("name"));
		assertEquals(null, entity.getBody().getErrors());
	}

	@Test
	@SuppressWarnings({ "rawtypes", "serial" })
	public void shouldReturnUserById() throws Exception {

		User inputUser = User.builder().id(1L).name("Demo").build();
		List<User> inputUsers = new ArrayList<User>() {{ add(inputUser); }};
		Response<User> inputResponse = Response.<User>builder().count(1L).items(inputUsers).build();

		when(userServiceMock.getUsers(1L)).thenReturn(inputResponse);

		ResponseEntity<Response> entity = restTemplate.getForEntity("/api/v1/users/1", Response.class);
		Map user = Map.class.cast(entity.getBody().getItems().get(0));

		assertEquals(HttpStatus.OK, entity.getStatusCode());
		assertEquals(1, entity.getBody().getCount());
		assertEquals(inputUser.getId().toString(), user.get("id").toString());
		assertEquals(inputUser.getName(), user.get("name"));
		assertEquals(null, entity.getBody().getErrors());
	}

	@Test
	@SuppressWarnings({ "rawtypes", "serial" })
	public void shouldSaveUser() throws Exception {

		User inputUser = User.builder().id(1L).name("Demo").build();
		List<User> inputUsers = new ArrayList<User>() {{ add(inputUser); }};
		Response<User> inputResponse = Response.<User>builder().count(1L).items(inputUsers).build();

		when(userServiceMock.saveUser(inputUser)).thenReturn(inputResponse);

		ResponseEntity<Response> entity = restTemplate.postForEntity("/api/v1/users/save", inputUser, Response.class);
		Map user = Map.class.cast(entity.getBody().getItems().get(0));

		assertEquals(HttpStatus.OK, entity.getStatusCode());
		assertEquals(1, entity.getBody().getCount());
		assertEquals(inputUser.getId().toString(), user.get("id").toString());
		assertEquals(inputUser.getName(), user.get("name"));
		assertEquals(null, entity.getBody().getErrors());
	}
}