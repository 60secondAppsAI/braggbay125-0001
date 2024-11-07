package com.braggbay125.dao;

import java.util.List;

import com.braggbay125.dao.GenericDAO;
import com.braggbay125.domain.Invoice;





public interface InvoiceDAO extends GenericDAO<Invoice, Integer> {
  
	List<Invoice> findAll();
	






}


