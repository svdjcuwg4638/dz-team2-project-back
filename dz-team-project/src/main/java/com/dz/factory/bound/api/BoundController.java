 package com.dz.factory.bound.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.bound.dto.BoundDto;
import com.dz.factory.bound.service.BoundService;
import com.dz.factory.common.domain.CMRespDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoundController {
	
	private final BoundService boundService;
	
	
	
	@GetMapping("/inbound/getid")
	public ResponseEntity<?> getMaxBoundId() {
		System.out.println("BoundID요청들어옴");
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",boundService.getMaxBoundId()),HttpStatus.CREATED);
	}
	
	@GetMapping("/inbound/getboundno")
	public ResponseEntity<?> getMaxBoundNo(@RequestParam String prefix){
		System.out.println(prefix);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",boundService.getMaxBoundNo(prefix)),HttpStatus.CREATED);
	}
	@PostMapping("/inbound/masterAdd")
	public ResponseEntity<?>  insertInbound(@RequestBody BoundDto boundDto) {
		boundService.insertInBound(boundDto);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",boundDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/inbound/all")
	public ResponseEntity<?> inboundAll(){
		List<BoundDto> inboundList = boundService.selectInboundAll();
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",inboundList),HttpStatus.CREATED);
	}

}
