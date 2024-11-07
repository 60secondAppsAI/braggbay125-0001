package com.braggbay125.dto;

import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import java.time.Year;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class BannerDTO {

	private Integer bannerId;

	private String imageUrl;

	private String targetUrl;

	private Date displayStartDate;

	private Date displayEndDate;






}
