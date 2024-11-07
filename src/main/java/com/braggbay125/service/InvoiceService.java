package com.braggbay125.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.braggbay125.domain.Invoice;
import com.braggbay125.dto.InvoiceDTO;
import com.braggbay125.dto.InvoiceSearchDTO;
import com.braggbay125.dto.InvoicePageDTO;
import com.braggbay125.dto.InvoiceConvertCriteriaDTO;
import com.braggbay125.service.GenericService;
import com.braggbay125.dto.common.RequestDTO;
import com.braggbay125.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface InvoiceService extends GenericService<Invoice, Integer> {

	List<Invoice> findAll();

	ResultDTO addInvoice(InvoiceDTO invoiceDTO, RequestDTO requestDTO);

	ResultDTO updateInvoice(InvoiceDTO invoiceDTO, RequestDTO requestDTO);

    Page<Invoice> getAllInvoices(Pageable pageable);

    Page<Invoice> getAllInvoices(Specification<Invoice> spec, Pageable pageable);

	ResponseEntity<InvoicePageDTO> getInvoices(InvoiceSearchDTO invoiceSearchDTO);
	
	List<InvoiceDTO> convertInvoicesToInvoiceDTOs(List<Invoice> invoices, InvoiceConvertCriteriaDTO convertCriteria);

	InvoiceDTO getInvoiceDTOById(Integer invoiceId);







}





