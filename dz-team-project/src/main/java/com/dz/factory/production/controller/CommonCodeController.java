package com.dz.factory.production.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.common.domain.CMRespDto;
import com.dz.factory.common.domain.Code;
import com.dz.factory.common.domain.Partner;
import com.dz.factory.management.service.PartnerService;
import com.dz.factory.production.dto.CommonCodeDto;
import com.dz.factory.production.service.CommonCodeService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping(value="/common-code")
public class CommonCodeController {
	private final CommonCodeService ccService;
	
	@GetMapping("/team")
	public ResponseEntity<?> getTeamCode(@RequestParam(required = false) String searchOption, String keyword  ) {
		
		if(searchOption==null&&keyword==null) {
			ArrayList<CommonCodeDto> teamCode = ccService.getAllTeam();
			return new ResponseEntity<>(new CMRespDto<>(1, "success",teamCode),HttpStatus.OK);
		}else{
			//코드로 찾기
			if(searchOption.equals("codeValue")){
				ArrayList<CommonCodeDto> teamCode = ccService.getByCodeValue(keyword);
				return new ResponseEntity<>(new CMRespDto<>(1, "success",teamCode),HttpStatus.OK);
				//명으로 찾기
			}else if(searchOption.equals("codeName")) {
				ArrayList<CommonCodeDto> teamCode = ccService.getByCodeName(keyword);
				return new ResponseEntity<>(new CMRespDto<>(1, "success",teamCode),HttpStatus.OK);
			}else {
				ArrayList<CommonCodeDto> teamCode = ccService.getByAll(keyword);
				return new ResponseEntity<>(new CMRespDto<>(1, "success",teamCode),HttpStatus.OK);
		}
		}
//		try {
//			ArrayList<Code> teamCode = ccService.getAllTeamCode();
//			return new ResponseEntity<>(new CMRespDto<>(1, "success",teamCode),HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(new CMRespDto<>(-1, "fail: " + e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}
	}
	
	
	

