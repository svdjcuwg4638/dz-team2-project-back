package com.dz.factory.production.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dz.factory.common.domain.CMRespDto;
import com.dz.factory.common.domain.Item;
import com.dz.factory.production.dto.ProductRelationDto;
import com.dz.factory.production.service.ProductionAddService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value="/production/add")
public class ProductionAddController {
	
	private final ProductionAddService addService;
	
	@GetMapping("/component")
	public ResponseEntity<?> getComponent(@RequestParam String itemCode){
		List<ProductRelationDto> relation= addService.getRelation(itemCode);
		List<Item> componentList=addService.getComponent(itemCode);
		
		HashMap<String, List> result = new HashMap<String,List>();
		result.put("componentList", componentList);
		result.put("relation", relation);
		
		
		return new ResponseEntity<>(new CMRespDto<>(1,"seccess",result),HttpStatus.OK);
	}
}
