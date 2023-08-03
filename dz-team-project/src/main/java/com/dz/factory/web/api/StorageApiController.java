package com.dz.factory.web.api;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.domain.management.Storage;
import com.dz.factory.service.StorageService;
import com.dz.factory.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class StorageApiController {

	private final StorageService storageService;
	
	@PostMapping("/storage/add")
	public ResponseEntity<?> storageAdd(@RequestBody Storage storage) {
		storageService.insert(storage);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",storage),HttpStatus.CREATED);
	}
	
	@GetMapping("/storage/all")
	public ResponseEntity<?> storageAll(){
		ArrayList<Storage> storageList = storageService.getAll();
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",storageList),HttpStatus.OK);
	}
	
}
