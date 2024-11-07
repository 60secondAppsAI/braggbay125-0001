package com.braggbay125.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.braggbay125.domain.Banner;
import com.braggbay125.dto.BannerDTO;
import com.braggbay125.dto.BannerSearchDTO;
import com.braggbay125.dto.BannerPageDTO;
import com.braggbay125.dto.BannerConvertCriteriaDTO;
import com.braggbay125.service.GenericService;
import com.braggbay125.dto.common.RequestDTO;
import com.braggbay125.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface BannerService extends GenericService<Banner, Integer> {

	List<Banner> findAll();

	ResultDTO addBanner(BannerDTO bannerDTO, RequestDTO requestDTO);

	ResultDTO updateBanner(BannerDTO bannerDTO, RequestDTO requestDTO);

    Page<Banner> getAllBanners(Pageable pageable);

    Page<Banner> getAllBanners(Specification<Banner> spec, Pageable pageable);

	ResponseEntity<BannerPageDTO> getBanners(BannerSearchDTO bannerSearchDTO);
	
	List<BannerDTO> convertBannersToBannerDTOs(List<Banner> banners, BannerConvertCriteriaDTO convertCriteria);

	BannerDTO getBannerDTOById(Integer bannerId);







}





