package it.polito.ezgas.allTestUser;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.InvalidUserException;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.service.impl.UserServiceimpl;

class testCheckUserDto {
	UserRepository userRepository;
	UserServiceimpl us;
	@BeforeEach
	void setUp() throws Exception {
		userRepository = mock(UserRepository.class);
		us = new UserServiceimpl();		
	}

	@Test
	void testCheckUserDto1() {
		User u1 = new User("davide","battaglia","mail@gmail.com",3);
		UserDto dto1 = new UserDto(5,"davide","battaglia","mail@gmail.com",3);
		String[] checks = new String[]{"nullcheck"};
		us.addUserRepository(userRepository);
//		when(userRepository.save(any(User.class))).thenReturn(u1);
		//getallusers
//		when(userRepository.getAllUsers()).thenReturn();
//		when(userRepository.findOne(anyInt())).thenReturn(u1);
		Boolean b = us.checkUserDto(dto1, checks);
		assertTrue(b);
	}
	// test 2 con ID == NULL
	// {"nullcheck","emailNotAlreadyUsed","rightEmailFormat","passwordRight"}
	
	@Test
	void testCheckUserDto2() {
		User u1 = new User("davide","battaglia","mail@gmail.com",3);
		UserDto dto1 = new UserDto(5,null,"battaglia","mail@gmail.com",3);
		String[] checks = new String[]{"nullcheck"};
		us.addUserRepository(userRepository);
//		when(userRepository.save(any(User.class))).thenReturn(u1);
		//getallusers
//		when(userRepository.getAllUsers()).thenReturn();
//		when(userRepository.findOne(anyInt())).thenReturn(u1);
		Boolean b = us.checkUserDto(dto1, checks);
		assertFalse(b);
	}
	@Test
	void testCheckUserDto3() {
		User u1 = new User("davide","battaglia","mail@gmail.com",3);
		UserDto dto1 = new UserDto(5,"davide","battaglia","mail@gmail.com",3);
		String[] checks = new String[]{"emailNotAlreadyUsed"};
		List<User> users = new ArrayList<User>();
		users.add(u1);
		us.addUserRepository(userRepository);
		when(userRepository.findAll()).thenReturn(users);
		
		when(userRepository.findOne(anyInt())).thenReturn(u1);
		when(userRepository.save(any(User.class))).thenReturn(u1);
		us.addUserRepository(userRepository);
		us.saveUser(dto1);
//		when(userRepository.save(any(User.class))).thenReturn(u1);
		//getallusers
//		when(userRepository.getAllUsers()).thenReturn();
//		when(userRepository.findOne(anyInt())).thenReturn(u1);
		Boolean b = us.checkUserDto(dto1, checks);
		assertFalse(b);
	}
	@Test
	void testCheckUserDto4() {
		User u1 = new User("davide","b","mail@gmail.com",3);
		UserDto dto1 = new UserDto(5,null,"b","mail@gmail.com",3);
		String[] checks = new String[]{"passwordRight"};
		us.addUserRepository(userRepository);
//		when(userRepository.save(any(User.class))).thenReturn(u1);
		//getallusers
//		when(userRepository.getAllUsers()).thenReturn();
//		when(userRepository.findOne(anyInt())).thenReturn(u1);
		Boolean b = us.checkUserDto(dto1, checks);
		assertFalse(b);
	}
	@Test
	void testCheckUserDto5() {
//		User u1 = new User("davide","b","mail@gmail.com",3);
		UserDto dto1 = new UserDto(5,"davide","battaglia","@gmail.com",3);
		String[] checks = new String[]{"rightEmailFormat"};
		us.addUserRepository(userRepository);
//		when(userRepository.save(any(User.class))).thenReturn(u1);
		//getallusers
//		when(userRepository.getAllUsers()).thenReturn();
//		when(userRepository.findOne(anyInt())).thenReturn(u1);
		Boolean b = us.checkUserDto(dto1, checks);
		assertFalse(b);
	}
}
