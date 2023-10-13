package com.dz.factory.bound.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.bound.dto.BoundDto;
import com.dz.factory.bound.dto.SearchInboundDetailDto;
import com.dz.factory.bound.dto.SearchInboundDto;
import com.dz.factory.bound.service.SearchBoundService;
import com.dz.factory.common.domain.CMRespDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SearchBoundController {

	private final SearchBoundService searchBoundService;
	
	@PostMapping("/inbound/searchMaster")
	public ResponseEntity<?> searchBound(@RequestBody SearchInboundDto searchInboundDto ){
		List<BoundDto> responseData = searchBoundService.searchBounds(searchInboundDto);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",responseData),HttpStatus.CREATED);
	}
	
	@PostMapping("/inbound/searchDetail")
	public ResponseEntity<?> searchBoundDetail(@RequestBody SearchInboundDetailDto searchInboundDetailDto ){
		List<BoundDto> responseData = searchBoundService.searchBoundDetailsWithMaster(searchInboundDetailDto);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",responseData),HttpStatus.CREATED);
	}
	
	@PostMapping("outbound/searchMaster")
	public ResponseEntity<?> searchOutBound(@RequestBody SearchInboundDto searchInboundDto ){
		List<BoundDto> responseData = searchBoundService.searchOutBounds(searchInboundDto);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",responseData),HttpStatus.CREATED);
	}
	
}
