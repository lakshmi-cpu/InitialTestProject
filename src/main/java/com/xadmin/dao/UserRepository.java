package com.xadmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xadmin.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
