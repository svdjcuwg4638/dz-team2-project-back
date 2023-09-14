package com.dz.factory.management.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.common.domain.CMRespDto;
import com.dz.factory.common.domain.Item;
import com.dz.factory.management.service.ItemService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ItemApiController {

	private final ItemService itemService;
	
	@GetMapping("/item/all")
	public ResponseEntity<?> itemGetAll(){
		ArrayList<Item> itemList = itemService.getAllItem();
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",itemList),HttpStatus.OK);
	}
	
	@PostMapping("/item/add")
	public ResponseEntity<?> itemAdd(@RequestBody Item item){
		System.out.println("-------------------------------");
		System.out.println(item.toString());
		itemService.itemAdd(item);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",item),HttpStatus.OK);
	}
	
	@PostMapping("/item/delete")
	public ResponseEntity<?> itemAdd(@RequestBody List<String> ids){
		itemService.delItem(ids);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",ids),HttpStatus.OK);
	}
	
	@PostMapping("/item/search")
	public ResponseEntity<?> itemSearch(@RequestBody HashMap<String, String> map){
		ArrayList<Item> list = itemService.getSearch(map);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",list),HttpStatus.OK);
	}
	
	@PostMapping("/item/modify")
	public ResponseEntity<?> itemModify(@RequestBody Item item){
		int result  = itemService.itemModify(item);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",item),HttpStatus.OK);
	}
	
}
