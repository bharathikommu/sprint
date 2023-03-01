package com.batch2.onlineShopping.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.batch2.onlineshopping.onlineShoppingApplication;
import com.batch2.onlineshopping.controller.UserController;
import com.batch2.onlineshopping.dto.UserDTO;
import com.batch2.onlineshopping.service.UserService;

@SpringBootTest(classes = onlineShoppingApplication.class)
@ExtendWith(MockitoExtension.class)
public class Usertest {
	@Mock
	private UserService userService;
	@InjectMocks
	private UserController userController;

	@Test
	public void testUserRegistration() {
		UserDTO userdto = new UserDTO();
		userdto.setUsername("testuser");
		userdto.setPassword("testpassword");
		when(userService.saveUserDetails(any(UserDTO.class))).thenReturn(userdto);
		UserDTO response = userController.userRegistration(userdto);
		assertNotNull(response);
		assertEquals("testuser", response.getUsername());
		assertEquals("testpassword", response.getPassword());
	}

	@Test
	public void testUpdateUser() {
		UserDTO userdto = new UserDTO();
		userdto.setUsername("testuser");
		userdto.setPassword("testpassword");
		when(userService.updateUser(any(UserDTO.class), eq(1))).thenReturn(userdto);
		UserDTO response = userController.updateUser(userdto, 1);
		assertNotNull(response);
		assertEquals("testuser", response.getUsername());
		assertEquals("testpassword", response.getPassword());
	}

	@Test
	public void testGetUser() {
		UserDTO userdto = new UserDTO();
		userdto.setUsername("testuser");
		userdto.setPassword("testpassword");
		when(userService.getUserDetails(eq(1))).thenReturn(userdto);
		UserDTO response = userController.getUser(1);
		assertNotNull(response);
		assertEquals("testuser", response.getUsername());
		assertEquals("testpassword", response.getPassword());
	}

//	@Test
//	public void testDeleteUser()
//	{
//		userController.deleteUser(1);
//    }
}
