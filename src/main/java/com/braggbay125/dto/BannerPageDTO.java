package com.braggbay125.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BannerPageDTO {

	private Integer page = 0;
	private Long totalElements = 0L;

	private List<BannerDTO> banners;
}





