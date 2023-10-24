package com.dz.factory.management.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dz.factory.common.domain.CMRespDto;
import com.dz.factory.common.domain.UnitPrice;
import com.dz.factory.management.service.UnitPriceService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UnitPriceApiController {

	private final UnitPriceService unitPriceService;
	
	@GetMapping("/unitPrice/all")
	public ResponseEntity<?> unitPriceGetAll(){
		ArrayList<UnitPrice> unitPriceList = unitPriceService.getAll();
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",unitPriceList),HttpStatus.OK);
	}
	
	@GetMapping("/unitPrice/current")
	public ResponseEntity<?> unitPriceGetCurrent(){
		ArrayList<UnitPrice> unitPriceList = unitPriceService.getCurrentList();
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",unitPriceList),HttpStatus.OK);
	}
	
	@GetMapping("/unitPrice/expected")
	public ResponseEntity<?> unitPriceGetExpected(){
		ArrayList<UnitPrice> unitPriceList = unitPriceService.getExpectedList();
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",unitPriceList),HttpStatus.OK);
	}
	
	@PostMapping("/unitPrice/add")
	public ResponseEntity<?> unitPriceAdd(@Valid @RequestBody UnitPrice unitPrice){
		unitPriceService.addUnitPrice(unitPrice);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",unitPrice),HttpStatus.OK);
	}
	
	@PostMapping("/unitprice/delete")
	public ResponseEntity<?> unitPriceDelete(@Valid @RequestBody List<Integer> unitPriceList){
		unitPriceService.deleteUnitPrice(unitPriceList);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",unitPriceList),HttpStatus.OK);
	}
}
