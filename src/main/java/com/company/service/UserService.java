package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import javax.transaction.Transactional;

import com.company.model.Response;
import com.company.model.User;
import com.company.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Response<User> getUsers() {

		Response<User> response = getResponse();

		response.setCount(userRepository.count());
		response.setItems(userRepository.findAll());

		return response;
	}

	public Response<User> getUsers(Long id) {

		Response<User> response = getResponse();
		User user = userRepository.findById(id).orElse(null);

		if (user != null) {
			response.setCount(1L);
			response.setItems(Arrays.asList(user));
		}

		return response;
	}

	@Transactional
	public Response<User> saveUser(User nextUser) {

		Response<User> response = getResponse();
		User user = userRepository.findById(nextUser.getId()).orElse(nextUser);

		response.setCount(1L);
		response.setItems(Arrays.asList(userRepository.save(user)));

		return response;
	}

	@Transactional
	public Response<User> delete(Long userId) {

		Response<User> response = getResponse();
		User user = userRepository.findById(userId).orElse(null);

		if (user != null) {
			userRepository.delete(user);
			response.setCount(1L);
			response.setItems(Arrays.asList(user));
		}

		return response;
	}

	public Response<User> getResponse() {
		return Response.<User>builder().build();
	}

	public Response<User> getResponse(String error) {
		return Response.<User>builder().errors(Arrays.asList(error)).build();
	}
}
