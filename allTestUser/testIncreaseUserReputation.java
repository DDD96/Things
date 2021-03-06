package it.polito.ezgas.allTestUser;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
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

class testIncreaseUserReputation {
	UserRepository userRepository;
	UserServiceimpl us;
	
	@BeforeEach
	void setUp() throws Exception {
		userRepository = mock(UserRepository.class);
		us = new UserServiceimpl();		
	}

	@Test
	void testIncreaseUserReputation1() throws InvalidUserException {
		User u1 = new User("davide","battaglia","mail@gmail.com",3);
		Integer ex = u1.getReputation();
		us.addUserRepository(userRepository);
//		when(userRepository.findAll()).thenReturn(users);
		when(userRepository.findOne(anyInt())).thenReturn(u1);
//		UserRepository spy = spy(userRepository);
//		doNothing().when(spy).delete(anyInt());		
		Integer reput = us.increaseUserReputation(5);
		assertEquals(reput, ex+1);
		
	}
	
	@Test
	public void testIncreaseUserReputation2() throws InvalidUserException {
		assertThrows(InvalidUserException.class, () -> { us.increaseUserReputation(null);			
		});	
	}
	
}
