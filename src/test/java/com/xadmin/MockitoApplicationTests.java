package com.xadmin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.xadmin.dao.UserRepository;
import com.xadmin.model.User;
import com.xadmin.service.UserService;
import org.junit.runner.RunWith;



@SpringBootTest
@RunWith(SpringRunner.class)
public class MockitoApplicationTests {

	
	@Autowired
	private UserService service;
	
	@MockBean
	private UserRepository repository;
	
	@Test
	public void getUsersTest()
	{
		when(repository.findAll()).thenReturn(Stream.of(new User(1,"admin1","admin@123")).collect(Collectors.toList()));
		assertEquals(1, service.getAllUsers().size());
	
	}
	
	public void addUserTest()
	{
		User user = new User(6, "admin6", "admin@6");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.saveUser(user));
	}
	
	public void deleteUser()
	{
		User user = new User(4,"admin4","admin@4");
		service.deleteUSerById(user.getId());
		verify(repository, times(1)).deleteById(user.getId());
	}
}
	
	


