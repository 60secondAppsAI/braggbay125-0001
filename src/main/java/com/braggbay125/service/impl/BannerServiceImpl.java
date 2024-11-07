package com.braggbay125.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



import com.braggbay125.dao.GenericDAO;
import com.braggbay125.service.GenericService;
import com.braggbay125.service.impl.GenericServiceImpl;
import com.braggbay125.dao.BannerDAO;
import com.braggbay125.domain.Banner;
import com.braggbay125.dto.BannerDTO;
import com.braggbay125.dto.BannerSearchDTO;
import com.braggbay125.dto.BannerPageDTO;
import com.braggbay125.dto.BannerConvertCriteriaDTO;
import com.braggbay125.dto.common.RequestDTO;
import com.braggbay125.dto.common.ResultDTO;
import com.braggbay125.service.BannerService;
import com.braggbay125.util.ControllerUtils;





@Service
public class BannerServiceImpl extends GenericServiceImpl<Banner, Integer> implements BannerService {

    private final static Logger logger = LoggerFactory.getLogger(BannerServiceImpl.class);

	@Autowired
	BannerDAO bannerDao;

	


	@Override
	public GenericDAO<Banner, Integer> getDAO() {
		return (GenericDAO<Banner, Integer>) bannerDao;
	}
	
	public List<Banner> findAll () {
		List<Banner> banners = bannerDao.findAll();
		
		return banners;	
		
	}

	public ResultDTO addBanner(BannerDTO bannerDTO, RequestDTO requestDTO) {

		Banner banner = new Banner();

		banner.setBannerId(bannerDTO.getBannerId());


		banner.setImageUrl(bannerDTO.getImageUrl());


		banner.setTargetUrl(bannerDTO.getTargetUrl());


		banner.setDisplayStartDate(bannerDTO.getDisplayStartDate());


		banner.setDisplayEndDate(bannerDTO.getDisplayEndDate());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		banner = bannerDao.save(banner);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<Banner> getAllBanners(Pageable pageable) {
		return bannerDao.findAll(pageable);
	}

	public Page<Banner> getAllBanners(Specification<Banner> spec, Pageable pageable) {
		return bannerDao.findAll(spec, pageable);
	}

	public ResponseEntity<BannerPageDTO> getBanners(BannerSearchDTO bannerSearchDTO) {
	
			Integer bannerId = bannerSearchDTO.getBannerId(); 
 			String imageUrl = bannerSearchDTO.getImageUrl(); 
 			String targetUrl = bannerSearchDTO.getTargetUrl(); 
     			String sortBy = bannerSearchDTO.getSortBy();
			String sortOrder = bannerSearchDTO.getSortOrder();
			String searchQuery = bannerSearchDTO.getSearchQuery();
			Integer page = bannerSearchDTO.getPage();
			Integer size = bannerSearchDTO.getSize();

	        Specification<Banner> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, bannerId, "bannerId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, imageUrl, "imageUrl"); 
			
			spec = ControllerUtils.andIfNecessary(spec, targetUrl, "targetUrl"); 
			
 			
 			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("imageUrl")), "%" + searchQuery.toLowerCase() + "%") 
             , cb.like(cb.lower(root.get("targetUrl")), "%" + searchQuery.toLowerCase() + "%") 
		));}
		
		Sort sort = Sort.unsorted();
		if (sortBy != null && !sortBy.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {
			if (sortOrder.equalsIgnoreCase("asc")) {
				sort = Sort.by(sortBy).ascending();
			} else if (sortOrder.equalsIgnoreCase("desc")) {
				sort = Sort.by(sortBy).descending();
			}
		}
		Pageable pageable = PageRequest.of(page, size, sort);

		Page<Banner> banners = this.getAllBanners(spec, pageable);
		
		//System.out.println(String.valueOf(banners.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(banners.getTotalPages()));
		
		List<Banner> bannersList = banners.getContent();
		
		BannerConvertCriteriaDTO convertCriteria = new BannerConvertCriteriaDTO();
		List<BannerDTO> bannerDTOs = this.convertBannersToBannerDTOs(bannersList,convertCriteria);
		
		BannerPageDTO bannerPageDTO = new BannerPageDTO();
		bannerPageDTO.setBanners(bannerDTOs);
		bannerPageDTO.setTotalElements(banners.getTotalElements());
		return ResponseEntity.ok(bannerPageDTO);
	}

	public List<BannerDTO> convertBannersToBannerDTOs(List<Banner> banners, BannerConvertCriteriaDTO convertCriteria) {
		
		List<BannerDTO> bannerDTOs = new ArrayList<BannerDTO>();
		
		for (Banner banner : banners) {
			bannerDTOs.add(convertBannerToBannerDTO(banner,convertCriteria));
		}
		
		return bannerDTOs;

	}
	
	public BannerDTO convertBannerToBannerDTO(Banner banner, BannerConvertCriteriaDTO convertCriteria) {
		
		BannerDTO bannerDTO = new BannerDTO();
		
		bannerDTO.setBannerId(banner.getBannerId());

	
		bannerDTO.setImageUrl(banner.getImageUrl());

	
		bannerDTO.setTargetUrl(banner.getTargetUrl());

	
		bannerDTO.setDisplayStartDate(banner.getDisplayStartDate());

	
		bannerDTO.setDisplayEndDate(banner.getDisplayEndDate());

	

		
		return bannerDTO;
	}

	public ResultDTO updateBanner(BannerDTO bannerDTO, RequestDTO requestDTO) {
		
		Banner banner = bannerDao.getById(bannerDTO.getBannerId());

		banner.setBannerId(ControllerUtils.setValue(banner.getBannerId(), bannerDTO.getBannerId()));

		banner.setImageUrl(ControllerUtils.setValue(banner.getImageUrl(), bannerDTO.getImageUrl()));

		banner.setTargetUrl(ControllerUtils.setValue(banner.getTargetUrl(), bannerDTO.getTargetUrl()));

		banner.setDisplayStartDate(ControllerUtils.setValue(banner.getDisplayStartDate(), bannerDTO.getDisplayStartDate()));

		banner.setDisplayEndDate(ControllerUtils.setValue(banner.getDisplayEndDate(), bannerDTO.getDisplayEndDate()));



        banner = bannerDao.save(banner);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public BannerDTO getBannerDTOById(Integer bannerId) {
	
		Banner banner = bannerDao.getById(bannerId);
			
		
		BannerConvertCriteriaDTO convertCriteria = new BannerConvertCriteriaDTO();
		return(this.convertBannerToBannerDTO(banner,convertCriteria));
	}







}
