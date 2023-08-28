package com.dz.factory.management.api;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.management.domain.Code;
import com.dz.factory.management.domain.ManageCode;
import com.dz.factory.management.dto.CMRespDto;
import com.dz.factory.management.service.CodeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CodeApiController {

	private final CodeService codeService;

	@GetMapping("/code/all")
	public ResponseEntity<?> codeAll(){
		ArrayList<Code> codeList = codeService.getAllCode();
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",codeList),HttpStatus.OK);
	}
	
	@GetMapping("/managementcode/all")
	public ResponseEntity<?> manageCodeAll(){
		ArrayList<ManageCode> manageCodeList = codeService.getAllManageCode();
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",manageCodeList),HttpStatus.OK);
	}
	
	@PostMapping("/managementcode/add")
	public ResponseEntity<?> manageCodeAdd(@RequestBody ManageCode data){
		codeService.addManageCode(data);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",data),HttpStatus.OK);
	}
	
}
