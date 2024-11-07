package com.braggbay125.dao;

import java.util.List;

import com.braggbay125.dao.GenericDAO;
import com.braggbay125.domain.Subscription;





public interface SubscriptionDAO extends GenericDAO<Subscription, Integer> {
  
	List<Subscription> findAll();
	






}


