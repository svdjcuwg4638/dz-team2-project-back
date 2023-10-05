package com.dz.factory.management.api;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.common.domain.CMRespDto;
import com.dz.factory.common.domain.ProductRelation;
import com.dz.factory.management.service.RelationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RelationApiController {

	private final RelationService relationService;
	
	@GetMapping("/relation/all")
	public ResponseEntity<?> relationAll(){
		ArrayList<ProductRelation> list = relationService.getRelationAll();
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",list),HttpStatus.OK);
	}
	
	
	@PostMapping("/relation/add")
	public ResponseEntity<?> relationAdd(@Valid @RequestBody ProductRelation dto){
		int result =  relationService.RelationAdd(dto);
		
		if(result == 0) {
			return new ResponseEntity<>(new CMRespDto<>(0,"이미 등록된 자재입니다.",dto),HttpStatus.OK);
		}
		if(result == 2) {
			return new ResponseEntity<>(new CMRespDto<>(2,"해당 품목의 소모자재에 같은 해당 품목을 넣을 수 없습니다.",dto),HttpStatus.OK);
		}
		
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",dto),HttpStatus.OK);
	}
	
	
	@PostMapping("relation/delete")
	public ResponseEntity<?> relationDel(@RequestBody ArrayList<ProductRelation> dtos){
		relationService.RelationDel(dtos);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",dtos),HttpStatus.OK);
	}
	
}
