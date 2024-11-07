package com.braggbay125.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.braggbay125.domain.Report;
import com.braggbay125.dto.ReportDTO;
import com.braggbay125.dto.ReportSearchDTO;
import com.braggbay125.dto.ReportPageDTO;
import com.braggbay125.dto.ReportConvertCriteriaDTO;
import com.braggbay125.service.GenericService;
import com.braggbay125.dto.common.RequestDTO;
import com.braggbay125.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface ReportService extends GenericService<Report, Integer> {

	List<Report> findAll();

	ResultDTO addReport(ReportDTO reportDTO, RequestDTO requestDTO);

	ResultDTO updateReport(ReportDTO reportDTO, RequestDTO requestDTO);

    Page<Report> getAllReports(Pageable pageable);

    Page<Report> getAllReports(Specification<Report> spec, Pageable pageable);

	ResponseEntity<ReportPageDTO> getReports(ReportSearchDTO reportSearchDTO);
	
	List<ReportDTO> convertReportsToReportDTOs(List<Report> reports, ReportConvertCriteriaDTO convertCriteria);

	ReportDTO getReportDTOById(Integer reportId);







}





