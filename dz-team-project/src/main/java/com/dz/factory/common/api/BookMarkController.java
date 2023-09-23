package com.dz.factory.common.api;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.common.domain.BookMark;
import com.dz.factory.common.domain.CMRespDto;
import com.dz.factory.common.service.BookMarkService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BookMarkController {

	private final BookMarkService bookMarkService;
	
	@GetMapping("/bookmark/all")
	public ResponseEntity<?> bookMarkAll(){
		ArrayList<BookMark> list = bookMarkService.getAllBookMark();
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",list),HttpStatus.OK);
	}
	
	@PostMapping("/bookMark/add")
	public ResponseEntity<?> bookMarkAdd(@RequestBody BookMark dto){
		int result = bookMarkService.bookMarkAdd(dto);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",result),HttpStatus.OK);
	}
	
}
