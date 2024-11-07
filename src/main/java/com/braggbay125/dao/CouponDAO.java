package com.braggbay125.dao;

import java.util.List;

import com.braggbay125.dao.GenericDAO;
import com.braggbay125.domain.Coupon;





public interface CouponDAO extends GenericDAO<Coupon, Integer> {
  
	List<Coupon> findAll();
	






}


