package com.dz.factory.management.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.common.domain.CMRespDto;
import com.dz.factory.common.domain.Partner;
import com.dz.factory.management.service.PartnerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PartnerApiController {

	private final PartnerService partnerService;
	
	@PostMapping("/partner/add")
	public ResponseEntity<?> partnerAdd(@RequestBody Partner partner) {
		partnerService.insert(partner);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",partner),HttpStatus.CREATED);
	}
	
	@GetMapping("/partner/all")
	public ResponseEntity<?> partnerGetAll() {
		ArrayList<Partner> partnerList = partnerService.selAllPartner();
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",partnerList),HttpStatus.OK);
	}
	
	@PostMapping("/partner/delete")
	public ResponseEntity<?> partnerdelete(@RequestBody List<Integer> ids) {
		partnerService.delete(ids);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",ids),HttpStatus.OK);
	}
}
