package com.dz.factory.production.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dz.factory.common.domain.CMRespDto;

@Controller
public class ProductionEditController {
	//생산내역 수정
	@PutMapping("")
	//production 테이블 수정
	//detail 테이블 수정
	//production 테이블 isDelete 변경
	public ResponseEntity<?> addProduction(@RequestBody HashMap<String,?> addData){
		addService.addProduction(addData);
		return new ResponseEntity<>(new CMRespDto<>(1, "seccess", null), HttpStatus.OK);
	}
}
