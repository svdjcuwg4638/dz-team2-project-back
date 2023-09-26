package com.dz.factory.management.api;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.common.domain.CMRespDto;
import com.dz.factory.common.domain.Code;
import com.dz.factory.common.domain.ManageCode;
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
	
	
	@PostMapping("/code/add")
	public ResponseEntity<?> CodeAdd(@RequestBody Code data){
		int result = codeService.addCode(data);
		return new ResponseEntity<>(new CMRespDto<>(result,"성공",data),HttpStatus.OK);
	}
	
	@PostMapping("/code/delete")
	public ResponseEntity<?> codeDelete(@RequestBody ArrayList<Code> codes){
		codeService.delCode(codes);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",codes),HttpStatus.OK);
	}
	
	
	@GetMapping("/managementcode/all")
	public ResponseEntity<?> manageCodeAll(){
		ArrayList<ManageCode> manageCodeList = codeService.getAllManageCode();
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",manageCodeList),HttpStatus.OK);
	}
	
	
	

	
}
