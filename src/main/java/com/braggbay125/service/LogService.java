package com.braggbay125.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.braggbay125.domain.Log;
import com.braggbay125.dto.LogDTO;
import com.braggbay125.dto.LogSearchDTO;
import com.braggbay125.dto.LogPageDTO;
import com.braggbay125.dto.LogConvertCriteriaDTO;
import com.braggbay125.service.GenericService;
import com.braggbay125.dto.common.RequestDTO;
import com.braggbay125.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface LogService extends GenericService<Log, Integer> {

	List<Log> findAll();

	ResultDTO addLog(LogDTO logDTO, RequestDTO requestDTO);

	ResultDTO updateLog(LogDTO logDTO, RequestDTO requestDTO);

    Page<Log> getAllLogs(Pageable pageable);

    Page<Log> getAllLogs(Specification<Log> spec, Pageable pageable);

	ResponseEntity<LogPageDTO> getLogs(LogSearchDTO logSearchDTO);
	
	List<LogDTO> convertLogsToLogDTOs(List<Log> logs, LogConvertCriteriaDTO convertCriteria);

	LogDTO getLogDTOById(Integer logId);







}





