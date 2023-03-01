package com.batch2.onlineshopping.service;

import com.batch2.onlineshopping.dto.UserDTO;
import com.batch2.onlineshopping.entity.User;
import com.batch2.onlineshopping.exceptions.UserNotFoundException;

public interface UserService {
	UserDTO saveUserDetails(UserDTO userdto);

	UserDTO updateUser(UserDTO userdto, int id);

	UserDTO getUserDetails(int id);

	String deleteUser(int id) throws UserNotFoundException;

}
