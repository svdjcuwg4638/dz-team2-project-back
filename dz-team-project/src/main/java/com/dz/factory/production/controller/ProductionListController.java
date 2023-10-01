package com.dz.factory.production.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dz.factory.common.domain.CMRespDto;
import com.dz.factory.production.service.ProductionListService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = "/production")
@RequiredArgsConstructor
public class ProductionListController {
	
	private final ProductionListService listService;

	@GetMapping("/list")
	//검색 필터에 맞는 조회
	public ResponseEntity<?> getProductionList(@RequestParam HashMap<String,?> searchFilter){
		
		HashMap<String,ArrayList<?>> result=listService.getProductionList(searchFilter);
		System.out.println(result);
		
		
		return new ResponseEntity<>(new CMRespDto<>(1,"success",result),HttpStatus.OK);
	}
	
	
//	@PutMapping("")
//	public ResponseEntity<?> editProduction(@RequestBody HashMap<String, ?> param ){
//		editService.updateProduction(param);
//		return new ResponseEntity<>(new CMRespDto<>(1, "success", null), HttpStatus.OK);
//	}
	
}
