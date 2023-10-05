package com.dz.factory.bound.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.bound.dto.OutBoundDto;
import com.dz.factory.bound.service.OutBoundService;
import com.dz.factory.common.domain.CMRespDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OutBoundController {

private final OutBoundService outboundService;
	
	
	
	@GetMapping("/outbound/getid")
	public ResponseEntity<?> getMaxBoundId() {
		System.out.println("BoundID요청들어옴");
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",outboundService.getMaxBoundId()),HttpStatus.CREATED);
	}
	
	@PostMapping("/outbound/masterAdd")
	public ResponseEntity<?>  insertOutbound(@RequestBody OutBoundDto outboundDto) {
		outboundService.insertOutBound(outboundDto);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",outboundDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/outbound/all")
	public ResponseEntity<?> OutboundAll(){
		List<OutBoundDto> outboundList = outboundService.selectOutboundAll();
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",outboundList),HttpStatus.CREATED);
	}
}
