package com.dz.factory.production.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.common.domain.CMRespDto;
import com.dz.factory.production.dto.CodeDto;
import com.dz.factory.production.service.CodeService;
import com.dz.factory.production.service.ItemCodeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/code")
public class CodeController {
	private final ApplicationContext applicationContext;
	
	//service bean에서 가져오는 메서드
	private CodeService getService(String serviceName) {
        return applicationContext.getBean(serviceName, CodeService.class);
    }
	
	public ResponseEntity<?> getCode( CodeService codeService, String searchOption, String keyword  ) {		
		if(searchOption==null&&keyword==null) {
			ArrayList<CodeDto> code = codeService.getAllCode();
			return new ResponseEntity<>(new CMRespDto<>(1, "success",code),HttpStatus.OK);
		}else{
			//코드로 찾기
			if(searchOption.equals("codeValue")){
				ArrayList<CodeDto> code = codeService.getByCodeValue(keyword);
				return new ResponseEntity<>(new CMRespDto<>(1, "success",code),HttpStatus.OK);
				//명으로 찾기
			}else if(searchOption.equals("codeName")) {
				ArrayList<CodeDto> code = codeService.getByCodeName(keyword);
				return new ResponseEntity<>(new CMRespDto<>(1, "success",code),HttpStatus.OK);
				//전체로 찾기 (코드, 명 둘다)
			}else {
				ArrayList<CodeDto> code = codeService.getByAll(keyword);
				return new ResponseEntity<>(new CMRespDto<>(1, "success",code),HttpStatus.OK);
			}
//		try {
//			ArrayList<Code> teamCode = ccService.getAllTeamCode();
//			return new ResponseEntity<>(new CMRespDto<>(1, "success",teamCode),HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(new CMRespDto<>(-1, "fail: " + e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
		}
	}
	
	@GetMapping("/item")
	public ResponseEntity<?> getItemCode(@RequestParam(required = false) String searchOption, String keyword  ) {
		CodeService itemService = getService("itemCodeService");
		return getCode(itemService, searchOption, keyword);
	}
		
	}

