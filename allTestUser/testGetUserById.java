package it.polito.ezgas.allTestUser;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import exception.InvalidUserException;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.service.impl.UserServiceimpl;

class testGetUserById {
//	@Autowired
	UserRepository userRepository;
	UserServiceimpl us;
	@BeforeEach
	public void setUp() throws Exception {
		userRepository = mock(UserRepository.class);
		User u1 = new User("davide","battaglia","mail@gmail.com",3);
//		UserDto dto1 = new UserDto(5,"davide","battaglia","mail@gmail.com",3);
		us = new UserServiceimpl();
		us.addUserRepository(userRepository); // metodo aggiunto nella classe UserServiceimpl
		when(userRepository.findOne(anyInt())).thenReturn(u1);
	}

	@Test
	public void testGetUserById1() throws InvalidUserException {
		UserDto dto1 = new UserDto(5,"davide","battaglia","mail@gmail.com",3);
		UserDto dto2 = us.getUserById(5);
		//assertTrue(dto1.getUserName().equals(dto2.getUserName()));
		//assertEquals(dto1,dto2);
//		Boolean b = dto1.getUserName().equals(dto2.getUserName());
//		Boolean b = dto1.equals(dto2);
//		System.out.println(b);	
//		assertTrue(b);
		assertTrue(dto1.getUserName().equals(dto2.getUserName()));
//		System.out.println(dto2.getUserName());	
		assertTrue(dto1.getPassword().equals(dto2.getPassword()));
		assertTrue(dto1.getEmail().equals(dto2.getEmail()));
		assertEquals(dto1.getReputation(),dto2.getReputation());
		//assertEquals(dto1.getUserId(),dto2.getUserId());
	}
	@Test
	public void testGetUserById2() throws InvalidUserException {
		assertThrows(InvalidUserException.class, () -> { us.getUserById(null);
			
		});
		
		
	}
	@Test
	public void testGetUserById3() throws InvalidUserException {
		when(userRepository.findOne(anyInt())).thenReturn(null);	
		assertNull(us.getUserById(5));
;	}

	
	
	
	
	
}
