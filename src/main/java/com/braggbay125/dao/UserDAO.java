package com.braggbay125.dao;

import java.util.List;

import com.braggbay125.dao.GenericDAO;
import com.braggbay125.domain.User;

import java.util.Optional;




public interface UserDAO extends GenericDAO<User, Integer> {
  
	List<User> findAll();
	






}


