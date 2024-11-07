package com.braggbay125.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import java.time.Year;
import jakarta.persistence.Transient;



@Entity
@Table(name="banners")
@Getter @Setter @NoArgsConstructor
public class Banner {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
  	@Column(name="banner_id")
	private Integer bannerId;
    
  	@Column(name="image_url")
	private String imageUrl;
    
  	@Column(name="target_url")
	private String targetUrl;
    
  	@Column(name="display_start_date")
	private Date displayStartDate;
    
  	@Column(name="display_end_date")
	private Date displayEndDate;
    
	




}
