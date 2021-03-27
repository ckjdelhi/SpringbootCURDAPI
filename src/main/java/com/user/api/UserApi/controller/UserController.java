package com.user.api.UserApi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.api.UserApi.model.UserForm;
import com.user.api.UserApi.repository.UserRepository;

@RestController
@RequestMapping(path = "/user-api")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path ="/")
	public @ResponseBody String sayHello() {
		return "Welcome to User API";
	}
	@PostMapping(path ="/addUser")
	public @ResponseBody String addUser(@RequestBody UserForm user) {
		userRepository.save(user);
		return "Saved";
	}
	@GetMapping(path ="/allUsers")
	public @ResponseBody Iterable<UserForm>  getAllUsers() {
		return userRepository.findAll();
	}
	@GetMapping(path ="/getUser/{id}")
	public @ResponseBody Optional<UserForm>  getUserById(@PathVariable String id) {
		return userRepository.findById(Integer.parseInt(id));
	}
	@PutMapping(path="/updateUser/{id}")
	public @ResponseBody String updateUser(@RequestBody UserForm user, @PathVariable String id) {
		UserForm existingData =userRepository.findById(Integer.parseInt(id)).get();
		existingData.setName(user.getName());
		existingData.setEmailId(user.getEmailId());
		existingData.setCountry(user.getCountry());
		userRepository.save(existingData);
		return "Updated";
	}
	@DeleteMapping(path="/deleteUser/{id}")
	public @ResponseBody String deleteUser(@PathVariable String id) {
		userRepository.deleteById(Integer.parseInt(id));
		return "Deleted";
	}
	
	
}
