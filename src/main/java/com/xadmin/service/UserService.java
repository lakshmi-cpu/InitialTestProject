package com.xadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xadmin.dao.UserRepository;
import com.xadmin.model.User;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository repository;
	
	public User saveUser(User user)
	{
		return repository.save(user);
	}
	
	public List<User> getAllUsers()
	{
		System.out.println("data from DataBase:- " +repository.findAll());
		return repository.findAll();
	}
	
	
	public void deleteUSerById(int id)
	{
		repository.deleteById(id);
	}

}
