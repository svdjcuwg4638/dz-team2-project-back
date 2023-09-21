package com.dz.factory.production.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dz.factory.common.domain.CMRespDto;
import com.dz.factory.common.domain.Inventory;
import com.dz.factory.common.domain.Item;
import com.dz.factory.common.domain.ProductRelation;
import com.dz.factory.production.dto.ComponentItemDto;
import com.dz.factory.production.dto.ProductionDto;
import com.dz.factory.production.dto.RelationDto;
import com.dz.factory.production.service.ProductionAddService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/production/add")
public class ProductionAddController {

	private final ProductionAddService addService;

	//자재
	@GetMapping("/component")
	public ResponseEntity<?> getComponentItems(@RequestParam String itemCode) {
//		List<ComponentItemDto> componentItems= addService.getComponentItems(itemCode);		
//		return new ResponseEntity<>(new CMRespDto<>(1,"seccess",componentItems),HttpStatus.OK);
		System.out.println(itemCode);
		List<RelationDto> relationList = addService.getRelation(itemCode);
		return new ResponseEntity<>(new CMRespDto<>(1, "seccess", relationList), HttpStatus.OK);
	}
	//재고
	@GetMapping("/inventory")
	public ResponseEntity<?> getInventory(@RequestParam String itemCode,
			@RequestParam(required = false) String storageCode, String locationCode) {
		List<Inventory> inventory = addService.getInventory(itemCode, storageCode, locationCode);

		if (inventory.size() == 1) {
			return new ResponseEntity<>(new CMRespDto<>(1, "seccess", inventory.get(0)), HttpStatus.OK);
		} else {
			{
				return new ResponseEntity<>(new CMRespDto<>(1, "seccess", inventory), HttpStatus.OK);
			}
		}

	}
	
	//생산등록
	@PostMapping("")
	public ResponseEntity<?> addProduction(@RequestBody HashMap<String,?> addData){
		addService.addProduction(addData);
		return new ResponseEntity<>(new CMRespDto<>(1, "seccess", null), HttpStatus.OK);
	}
}
