package com.estudo.filhotarciso.userdpt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.filhotarciso.userdpt.entities.User;
import com.estudo.filhotarciso.userdpt.repository.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserControllers {

	@Autowired
	private UserRepository repository;

	@GetMapping
	public List<User> findAll() {
		List<User> result = repository.findAll();
		return result;
	}

	@GetMapping(value = "/{id}")
	public User findById(@PathVariable Long id) {
		User result = repository.findById(id).get();
		return result;
	}

	@PostMapping
	public User insert(@RequestBody User user) {
		User result = repository.save(user);
		return result;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) throws EmptyResultDataAccessException {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
