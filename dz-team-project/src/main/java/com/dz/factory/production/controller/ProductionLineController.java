package com.dz.factory.production.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dz.factory.common.domain.CMRespDto;
import com.dz.factory.common.domain.ProductionLine;
import com.dz.factory.production.service.ProductionLineService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = "/production/line")
@RequiredArgsConstructor
public class ProductionLineController {
	private final ProductionLineService lineService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllLine(){
		ArrayList<ProductionLine> lineList=new ArrayList<ProductionLine>();
		return new ResponseEntity<>(new CMRespDto<>(1, "seccess", lineList), HttpStatus.OK);
		
	}
}
