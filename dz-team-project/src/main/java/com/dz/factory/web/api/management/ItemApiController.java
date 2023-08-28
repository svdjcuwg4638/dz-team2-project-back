package com.dz.factory.web.api.management;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.domain.management.Item;
import com.dz.factory.service.management.ItemService;
import com.dz.factory.web.dto.CMRespDto;

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
		itemService.itemAdd(item);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",item),HttpStatus.OK);
	}
	
	@PostMapping("/item/delete")
	public ResponseEntity<?> itemAdd(@RequestBody List<Integer> ids){
		itemService.delItem(ids);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",ids),HttpStatus.OK);
	}
	
}