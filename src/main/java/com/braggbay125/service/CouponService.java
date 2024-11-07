package com.braggbay125.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.braggbay125.domain.Coupon;
import com.braggbay125.dto.CouponDTO;
import com.braggbay125.dto.CouponSearchDTO;
import com.braggbay125.dto.CouponPageDTO;
import com.braggbay125.dto.CouponConvertCriteriaDTO;
import com.braggbay125.service.GenericService;
import com.braggbay125.dto.common.RequestDTO;
import com.braggbay125.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface CouponService extends GenericService<Coupon, Integer> {

	List<Coupon> findAll();

	ResultDTO addCoupon(CouponDTO couponDTO, RequestDTO requestDTO);

	ResultDTO updateCoupon(CouponDTO couponDTO, RequestDTO requestDTO);

    Page<Coupon> getAllCoupons(Pageable pageable);

    Page<Coupon> getAllCoupons(Specification<Coupon> spec, Pageable pageable);

	ResponseEntity<CouponPageDTO> getCoupons(CouponSearchDTO couponSearchDTO);
	
	List<CouponDTO> convertCouponsToCouponDTOs(List<Coupon> coupons, CouponConvertCriteriaDTO convertCriteria);

	CouponDTO getCouponDTOById(Integer couponId);







}





