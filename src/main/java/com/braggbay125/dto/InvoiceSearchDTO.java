package com.braggbay125.dto;

import java.sql.Timestamp;
import java.time.Year;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class InvoiceSearchDTO {

	private Integer page = 0;
	private Integer size;
	private String sortBy;
	private String sortOrder;
	private String searchQuery;

	private Integer invoiceId;
	
	private Double totalAmount;
	
	private Date issueDate;
	
	private Date dueDate;
	
}
