package com.company;

import com.company.model.*;
import com.company.repository.UserRepository;
import com.company.service.UserService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@TestInstance(PER_CLASS)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = DemoApplication.class)
public class UserServiceTest {

	private UserService userService;
	
	@MockBean
	UserRepository userRepositoryMock;

    @BeforeAll
    public void init() {
        userService = new UserService(userRepositoryMock);
    }

	@Test
	@SuppressWarnings({ "serial" })
	public void shouldReturnUsers() throws Exception {

		User inputUser = User.builder().name("Demo").build();
		List<User> inputUsers = new ArrayList<User>() {{ add(inputUser); }};

		when(userRepositoryMock.count()).thenReturn(1L);
		when(userRepositoryMock.findAll()).thenReturn(inputUsers);

		Response<User> response = userService.getUsers();

		assertEquals(1, response.getCount());
		assertEquals(inputUser, response.getItems().get(0));
		assertEquals(null, response.getErrors());
	}

	@Test
	public void shouldReturnUserById() throws Exception {

		User inputUser = User.builder().id(1L).name("Demo").build();

		when(userRepositoryMock.count()).thenReturn(1L);
		when(userRepositoryMock.findById(inputUser.getId())).thenReturn(Optional.of(inputUser));

		Response<User> response = userService.getUsers(inputUser.getId());

		assertEquals(1, response.getCount());
		assertEquals(inputUser, response.getItems().get(0));
		assertEquals(null, response.getErrors());
	}

	@Test
	public void shouldSaveUser() throws Exception {

		User inputUser = User.builder().id(1L).name("Demo").build();

		when(userRepositoryMock.save(inputUser)).thenReturn(inputUser);
		when(userRepositoryMock.findById(inputUser.getId())).thenReturn(Optional.of(inputUser));

		Response<User> response = userService.saveUser(inputUser);

		assertEquals(1, response.getCount());
		assertEquals(inputUser, response.getItems().get(0));
		assertEquals(null, response.getErrors());
	}
}