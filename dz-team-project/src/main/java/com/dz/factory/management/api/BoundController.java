package com.dz.factory.management.api;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.common.domain.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoundController {

	private final BoundService boundService;
	
	@GetMapping("/inbound/getBoundId")
	public ResponseEntity<?> codeAll(){
		int bound_id = boundService.getBound_id(1);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",bound_id),HttpStatus.OK);
	}
}
