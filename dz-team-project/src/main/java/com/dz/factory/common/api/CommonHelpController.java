package com.dz.factory.common.api;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.common.domain.CMRespDto;
import com.dz.factory.common.dto.CommonHelpDto;
import com.dz.factory.common.service.CommonHelpService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class CommonHelpController {

	private final CommonHelpService commonHelpService;

	@PostMapping("/common/help")
	public ResponseEntity<?> commonHelp(@RequestBody CommonHelpDto data){
		ArrayList<?> list  = commonHelpService.searchHelp(data);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",list),HttpStatus.OK);
	}

	
	
}
