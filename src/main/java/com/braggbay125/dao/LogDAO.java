package com.braggbay125.dao;

import java.util.List;

import com.braggbay125.dao.GenericDAO;
import com.braggbay125.domain.Log;





public interface LogDAO extends GenericDAO<Log, Integer> {
  
	List<Log> findAll();
	






}


