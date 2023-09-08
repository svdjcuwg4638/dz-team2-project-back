package com.dz.factory.storage.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.common.domain.CMRespDto;
import com.dz.factory.storage.dto.Inventory;
import com.dz.factory.storage.service.CodeListService;
import com.dz.factory.storage.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class InventoryController {
	private final InventoryService inventoryService; 
	
	@GetMapping("/inventory/all")
	public ResponseEntity<?> InventoryGetAll(){
		ArrayList<Inventory> inventoryList = inventoryService.getInventoryAll(); 
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",inventoryList),HttpStatus.OK);

	}
	
	@PostMapping("/inventory/add")
	public ResponseEntity<?> inventoryAdd(@RequestBody List<Inventory> inventoryList){
		 if (inventoryList != null && !inventoryList.isEmpty()) {
		        for (Inventory inventory : inventoryList) {
		            // 개별 Inventory 객체에 대한 처리 수행
		            System.out.println(inventory.toString());
		        }		
		 }
		        return new ResponseEntity<>(new CMRespDto<>(1,"성공",inventoryList),HttpStatus.CREATED);

	}

}
