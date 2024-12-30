package com.trustmed.userService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustmed.userService.entity.User;
import com.trustmed.userService.exception.BadRequestException;
import com.trustmed.userService.exception.NotFoundException;
import com.trustmed.userService.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	@Autowired
	private final UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		
		if(user==null|| user.getUserName()==null) {
			throw new BadRequestException("user or userName can't be null");
		}
		if(userRepository.existsById(user.getUserName())) {
			throw new BadRequestException("user already plesent with userName: "+user.getUserName());
		}
		return userRepository.save(user);
	}

	public List<User> getAllUser() {
		List<User> result= userRepository.findAll();
		if(result.isEmpty()) {
			throw new NotFoundException("No User Found!");
		}

		return result;
	}

	public Optional<User> getUserByUserName(String userName) {

		return Optional.ofNullable(userRepository.findById(userName).orElseThrow(()->new NotFoundException("User Not Found with given userName:"+ userName)));
	}

	public void deleteUser(String userName) {
//		Optional<User> result=userRepository.findById(userName);
		if(!userRepository.existsById(userName)) {
			throw new NotFoundException("Did not found given userName: "+userName);
		}
		userRepository.deleteById(userName);
	}
	
	public Optional<User> updateUser(String userName, User userDetails) {
		// TODO Auto-generated method stub
		if (userDetails == null || userName == null) {
			throw new BadRequestException("User details or User Name cannot be null");
		}
		return userRepository.findById(userName).map(user-> {
			user.setActive(userDetails.getActive());
			user.setPassword(userDetails.getPassword());
			user.setRole(userDetails.getRole());
			return userRepository.save(user);
		});
	}
}