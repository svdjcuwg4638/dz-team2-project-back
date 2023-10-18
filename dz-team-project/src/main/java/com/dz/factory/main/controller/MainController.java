package com.dz.factory.main.controller;

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
import com.dz.factory.main.service.MainService;
import com.dz.factory.production.service.ProductionListService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = "/main")
@RequiredArgsConstructor
public class MainController {
	
	private final MainService mainService;

	@GetMapping("")
	//입고, 출고, 생산, 재고 건수 조회
	public ResponseEntity<?> getProductionList(){
		
		HashMap<String,Integer> result=mainService.getSummary();
		System.out.println(result);
		
		return new ResponseEntity<>(new CMRespDto<>(1,"success",result),HttpStatus.OK);
	}
	
	
}
