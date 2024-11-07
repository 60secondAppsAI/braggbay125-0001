package com.braggbay125.dao;

import java.util.List;

import com.braggbay125.dao.GenericDAO;
import com.braggbay125.domain.Notification;





public interface NotificationDAO extends GenericDAO<Notification, Integer> {
  
	List<Notification> findAll();
	






}


