package com.dz.factory.management.api;

import java.util.ArrayList;
import java.util.List;

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
		System.out.println("-------------------------");
		System.out.println(dto.toString());
		relationService.RelationAdd(dto);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",dto),HttpStatus.OK);
	}
	
	@PostMapping("relation/delete")
	public ResponseEntity<?> relationDel(@RequestBody List<String> ids){
		relationService.RelationDel(ids);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",ids),HttpStatus.OK);
	}
	
}
