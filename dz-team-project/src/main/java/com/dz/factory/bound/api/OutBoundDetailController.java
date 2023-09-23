package com.dz.factory.bound.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.bound.dto.OutBoundDetailDto;
import com.dz.factory.bound.service.OutBoundDetailService;
import com.dz.factory.common.domain.CMRespDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OutBoundDetailController {

private final OutBoundDetailService outboundDetailService;
	
	@PostMapping("/outbound/detailAdd")
	public ResponseEntity<?> insertOutboundDetail(@RequestBody OutBoundDetailDto outboundDetailDto){
		System.out.println(outboundDetailDto);
		outboundDetailService.insertOutboundDetail(outboundDetailDto);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",outboundDetailDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/outbound/detailall")
	public ResponseEntity<?> selectOutboundDetailAll(){
		List<OutBoundDetailDto> outboundDetailList = outboundDetailService.selectOutboundDetailAll();
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",outboundDetailList),HttpStatus.CREATED);
	}
}
