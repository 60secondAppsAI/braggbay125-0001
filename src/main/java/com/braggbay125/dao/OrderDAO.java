package com.braggbay125.dao;

import java.util.List;

import com.braggbay125.dao.GenericDAO;
import com.braggbay125.domain.Order;





public interface OrderDAO extends GenericDAO<Order, Integer> {
  
	List<Order> findAll();
	






}


