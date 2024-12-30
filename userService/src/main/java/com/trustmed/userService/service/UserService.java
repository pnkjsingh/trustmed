package com.trustmed.userService.service;

import java.util.List;
import java.util.Optional;

import com.trustmed.userService.entity.User;

public interface UserService {

	User saveUser(User user);

	List<User> getAllUser();

	Optional<User> getUserByUserName(String userName);

	void deleteUser(String userName);

	Optional<User> updateUser(String userName, User userDetails);

}