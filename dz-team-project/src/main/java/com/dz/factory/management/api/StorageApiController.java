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
import com.dz.factory.common.domain.Location;
import com.dz.factory.common.domain.Storage;
import com.dz.factory.management.service.StorageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class StorageApiController {

	private final StorageService storageService;
	
	@PostMapping("/storage/add")
	public ResponseEntity<?> storageAdd(@RequestBody Storage storage) {
		int result = storageService.insert(storage);
		return new ResponseEntity<>(new CMRespDto<>(result,"성공",storage),HttpStatus.CREATED);
	}
	
	@GetMapping("/storage/all")
	public ResponseEntity<?> storageAll(){
		ArrayList<Storage> storageList = storageService.getAll();
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",storageList),HttpStatus.OK);
	}
	
	@PostMapping("/storage/delete")
	public ResponseEntity<?> storageDelete(@RequestBody List<String> codes){
		ArrayList<String> list = storageService.delStorage(codes);
		if (list  == null) {
			return new ResponseEntity<>(new CMRespDto<>(1,"성공",codes),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(new CMRespDto<>(2,"실패",list),HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/storage/locationAdd")
	public ResponseEntity<?> loacationAdd(@RequestBody Location locationDto){
		int result = storageService.addLocation(locationDto);
		return new ResponseEntity<>(new CMRespDto<>(result,"성공",locationDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/location/all")
	public ResponseEntity<?> locationAll(){
		ArrayList<Location> locationList = storageService.getLocationAll();
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",locationList),HttpStatus.OK);
	}
	
	@PostMapping("location/delete")
	public ResponseEntity<?> locationDelete(@RequestBody ArrayList<Location> dtos){
		ArrayList<String > list =  storageService.delLocation(dtos);
		if (list  == null) {
			return new ResponseEntity<>(new CMRespDto<>(1,"성공",dtos),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(new CMRespDto<>(2,"실패",list),HttpStatus.OK);
		}
	}
	
	
	
}
