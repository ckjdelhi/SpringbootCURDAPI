package com.user.api.UserApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.user.api.UserApi.model.UserForm;

public interface UserRepository  extends CrudRepository<UserForm, Integer>{
	
}
