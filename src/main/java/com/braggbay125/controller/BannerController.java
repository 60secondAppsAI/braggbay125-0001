package com.braggbay125.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;


import com.braggbay125.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;

import com.braggbay125.domain.Banner;
import com.braggbay125.dto.BannerDTO;
import com.braggbay125.dto.BannerSearchDTO;
import com.braggbay125.dto.BannerPageDTO;
import com.braggbay125.service.BannerService;
import com.braggbay125.dto.common.RequestDTO;
import com.braggbay125.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/banner")
@RestController
public class BannerController {

	private final static Logger logger = LoggerFactory.getLogger(BannerController.class);

	@Autowired
	BannerService bannerService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Banner> getAll() {

		List<Banner> banners = bannerService.findAll();
		
		return banners;	
	}

	@GetMapping(value = "/{bannerId}")
	@ResponseBody
	public BannerDTO getBanner(@PathVariable Integer bannerId) {
		
		return (bannerService.getBannerDTOById(bannerId));
	}

 	@RequestMapping(value = "/addBanner", method = RequestMethod.POST)
	public ResponseEntity<?> addBanner(@RequestBody BannerDTO bannerDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = bannerService.addBanner(bannerDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/banners")
	public ResponseEntity<BannerPageDTO> getBanners(BannerSearchDTO bannerSearchDTO) {
 
		return bannerService.getBanners(bannerSearchDTO);
	}	

	@RequestMapping(value = "/updateBanner", method = RequestMethod.POST)
	public ResponseEntity<?> updateBanner(@RequestBody BannerDTO bannerDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = bannerService.updateBanner(bannerDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
