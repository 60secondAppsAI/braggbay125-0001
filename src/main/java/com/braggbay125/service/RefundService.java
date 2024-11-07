package com.braggbay125.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.braggbay125.domain.Refund;
import com.braggbay125.dto.RefundDTO;
import com.braggbay125.dto.RefundSearchDTO;
import com.braggbay125.dto.RefundPageDTO;
import com.braggbay125.dto.RefundConvertCriteriaDTO;
import com.braggbay125.service.GenericService;
import com.braggbay125.dto.common.RequestDTO;
import com.braggbay125.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface RefundService extends GenericService<Refund, Integer> {

	List<Refund> findAll();

	ResultDTO addRefund(RefundDTO refundDTO, RequestDTO requestDTO);

	ResultDTO updateRefund(RefundDTO refundDTO, RequestDTO requestDTO);

    Page<Refund> getAllRefunds(Pageable pageable);

    Page<Refund> getAllRefunds(Specification<Refund> spec, Pageable pageable);

	ResponseEntity<RefundPageDTO> getRefunds(RefundSearchDTO refundSearchDTO);
	
	List<RefundDTO> convertRefundsToRefundDTOs(List<Refund> refunds, RefundConvertCriteriaDTO convertCriteria);

	RefundDTO getRefundDTOById(Integer refundId);







}





