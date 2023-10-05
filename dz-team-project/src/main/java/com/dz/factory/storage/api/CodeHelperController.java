package com.dz.factory.storage.api;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.common.domain.CMRespDto;
import com.dz.factory.common.domain.Storage;
import com.dz.factory.storage.dto.CodeAll;
import com.dz.factory.storage.service.CodeListService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CodeHelperController {
	private final CodeListService codeListService;
	
	@GetMapping("/codehelper/storage")
	public ResponseEntity<?> StorageCode(){
		ArrayList<Storage> storagecodeList =codeListService.getStorageCode();
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",storagecodeList),HttpStatus.OK);

	}

}
