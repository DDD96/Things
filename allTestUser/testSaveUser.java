package it.polito.ezgas.allTestUser;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.polito.ezgas.entity.User;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.service.impl.UserServiceimpl;

class testSaveUser {
	UserRepository userRepository;
	UserServiceimpl us;

	@BeforeEach
	void setUp() throws Exception {
		userRepository = mock(UserRepository.class);
		//User u1 = new User("davide","battaglia","mail@gmail.com",3);
//		UserDto dto1 = new UserDto(5,"davide","battaglia","mail@gmail.com",3);
		us = new UserServiceimpl();
		//us.addUserRepository(userRepository); // metodo aggiunto nella classe UserServiceimpl	
	}

	@Test
	void testSaveUser1() {
		User u1 = new User("davide","battaglia","mail@gmail.com",3);
//		UserServiceimpl us2 = mock(UserServiceimpl.class);
		//when(us2.checkUserDto(any(UserDto.class), any(String[].class))).thenReturn(true);
		// public checkUserDto 
		us.addUserRepository(userRepository);
		when(userRepository.save(any(User.class))).thenReturn(u1);
		// true/ false per check!!!!		
		// when per checkUserDto ?????
		UserDto dto1 = new UserDto(null,"davide","battaglia","mail@gmail.com",3);
		UserDto dto2 = us.saveUser(dto1);
//		System.out.println(dto2);	
		
		assertTrue(dto1.getUserName().equals(dto2.getUserName()));
		assertTrue(dto1.getPassword().equals(dto2.getPassword()));
		assertTrue(dto1.getEmail().equals(dto2.getEmail()));
		assertEquals(dto1.getReputation(),dto2.getReputation());
	}
	
	@Test
	void testSaveUser2() {
		User u1 = new User("davide","battaglia","mail@gmail.com",3);
		us.addUserRepository(userRepository);
		when(userRepository.save(any(User.class))).thenReturn(u1);
		when(userRepository.findOne(anyInt())).thenReturn(u1);
		
		UserDto dto1 = new UserDto(5,"davide","battaglia","mail@gmail.com",3);
		UserDto dto2 = us.saveUser(dto1);
		
		assertTrue(dto1.getUserName().equals(dto2.getUserName()));
		assertTrue(dto1.getPassword().equals(dto2.getPassword()));
		assertTrue(dto1.getEmail().equals(dto2.getEmail()));
		assertEquals(dto1.getReputation(),dto2.getReputation());
	}

}


	
