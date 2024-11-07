package com.braggbay125.dao;

import java.util.List;

import com.braggbay125.dao.GenericDAO;
import com.braggbay125.domain.Banner;





public interface BannerDAO extends GenericDAO<Banner, Integer> {
  
	List<Banner> findAll();
	






}


