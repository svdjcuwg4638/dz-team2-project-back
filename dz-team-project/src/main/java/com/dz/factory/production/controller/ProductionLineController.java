package com.dz.factory.production.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dz.factory.common.domain.CMRespDto;
import com.dz.factory.common.domain.ProductionLine;
import com.dz.factory.production.dto.ProductionLineDto;
import com.dz.factory.production.service.ProductionLineService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = "/production/line")
@RequiredArgsConstructor
public class ProductionLineController {
	private final ProductionLineService lineService;
	@GetMapping("")
	public ResponseEntity<?> getAllLine(){
		
		ArrayList<ProductionLineDto> lineList=lineService.getAllLine();
		return new ResponseEntity<>(new CMRespDto<>(1, "seccess", lineList), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> saveLine(@RequestBody HashMap<String,ArrayList<?>>param){
		ArrayList<HashMap<String,?>> addData = (ArrayList<HashMap<String,?>>) param.get("add");
		ArrayList<HashMap<String,?>> editData = (ArrayList<HashMap<String,?>>) param.get("edit");
		ArrayList<String> deleteKey = (ArrayList<String>) param.get("delete");
		
		
		String duplicateKey="";
		
		if (addData.size()>0) {
//			System.out.println("===================");
//			System.out.println(addData.size());
			duplicateKey = lineService.addLine(addData);
		}
		if(editData.size()>0){
			lineService.editLine(editData);
		}
		if(deleteKey.size()>0) {
			lineService.deleteLine(deleteKey);
		}
		
		if(!duplicateKey.equals("")) {
			HashMap<String,String> res=new HashMap<String,String> ();
			res.put("duplicateKey", duplicateKey);
			return new ResponseEntity<>(res,HttpStatus.CONFLICT);
		}else {
			return new ResponseEntity<>(new CMRespDto<>(1, "seccess", null), HttpStatus.OK);
		}
		
	}
}
