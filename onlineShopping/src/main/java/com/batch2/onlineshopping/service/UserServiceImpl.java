package com.batch2.onlineshopping.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.batch2.onlineshopping.dto.UserDTO;
import com.batch2.onlineshopping.entity.User;
import com.batch2.onlineshopping.exceptions.UserNotFoundException;
import com.batch2.onlineshopping.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDTO saveUserDetails(UserDTO userdto) {

		if (userdto.getPassword().equals(userdto.getConfirmPassword())) {
			User user= new User();
			user.setUsername(userdto.getUsername());
			user.setEmailId(userdto.getEmailId());
			user.setPhoneNo(userdto.getPhoneNo());
			user.setPassword(new BCryptPasswordEncoder().encode(userdto.getPassword()));
			user.setRole(userdto.getRole());
			User user1=userRepository.save(user);
			
			UserDTO userdto1=new UserDTO();
			userdto1.setUsername(user1.getUsername());
			userdto1.setEmailId(user1.getEmailId());
			userdto1.setPhoneNo(user1.getPhoneNo());
			userdto1.setRole(user1.getRole());
			return userdto1;
		}
		return null;

	}

	@Override
	public UserDTO updateUser(UserDTO userdto, int id) {

		if (userdto.getPassword().equals(userdto.getConfirmPassword())) {
			User user= new User();
			user.setId(id);
			user.setUsername(userdto.getUsername());
			user.setEmailId(userdto.getEmailId());
			user.setPhoneNo(userdto.getPhoneNo());
			user.setPassword(new BCryptPasswordEncoder().encode(userdto.getPassword()));
			user.setRole(userdto.getRole());
			User user1 = userRepository.save(user);
			UserDTO userdto1=new UserDTO();
			userdto1.setUsername(user1.getUsername());
			userdto1.setEmailId(user1.getEmailId());
			userdto1.setPhoneNo(user1.getPhoneNo());
			userdto1.setRole(user1.getRole());
			return userdto1;
		}
		return null;

	}
	@Override
	public UserDTO getUserDetails(int id) {

		Optional<User> user = userRepository.findById(id);
		UserDTO userdto1=new UserDTO();
		userdto1.setUsername(user.get().getUsername());
		userdto1.setEmailId(user.get().getEmailId());
		userdto1.setPhoneNo(user.get().getPhoneNo());
		userdto1.setRole(user.get().getRole());
		return userdto1;
	}

	@Override
	public String deleteUser(int id) throws UserNotFoundException {

		if (userRepository.existsById(id)) {

			userRepository.deleteById(id);

			return "User deleted successfuly";
		}
		throw new UserNotFoundException("user not found");
	}
	
	
}
