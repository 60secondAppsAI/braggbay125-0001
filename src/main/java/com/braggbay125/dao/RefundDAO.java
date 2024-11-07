package com.braggbay125.dao;

import java.util.List;

import com.braggbay125.dao.GenericDAO;
import com.braggbay125.domain.Refund;





public interface RefundDAO extends GenericDAO<Refund, Integer> {
  
	List<Refund> findAll();
	






}


