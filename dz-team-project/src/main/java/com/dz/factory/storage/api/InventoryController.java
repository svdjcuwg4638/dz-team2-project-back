package com.dz.factory.storage.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.common.domain.CMRespDto;
import com.dz.factory.common.domain.Location;
import com.dz.factory.common.domain.Storage;
import com.dz.factory.storage.dto.InventoryDto;
import com.dz.factory.storage.dto.InventoryForm;
import com.dz.factory.storage.dto.Registration;
import com.dz.factory.storage.service.CodeListService;
import com.dz.factory.storage.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class InventoryController {
	private final InventoryService inventoryService; 
	
	@GetMapping("/inventory/all")
	public ResponseEntity<?> InventoryGetAll(){
		ArrayList<InventoryDto> inventoryList = inventoryService.getInventoryAll(); 
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",inventoryList),HttpStatus.OK);

	}

	
	@PostMapping("/inventory/registration")
	public ResponseEntity<?> inventoryAdd(@RequestBody List<Registration> inventoryList){

		System.out.println(inventoryList);
//		 if (inventoryList != null && !inventoryList.isEmpty()) {
//		        for (Registration inventory : inventoryList) {
//		            // 개별 Inventory 객체에 대한 처리 수행
//		            System.out.println(inventory);
//		        }		
//		 }
		        return new ResponseEntity<>(new CMRespDto<>(1,"성공",inventoryList),HttpStatus.CREATED);
	}
	
	@PostMapping("/inventory/searchForm")
	public ResponseEntity<?> searchInventoryByForm(@RequestBody  InventoryForm searchinventorydata){
	    List<InventoryDto> inventoryList = new ArrayList<>();
	    List<InventoryDto> inventory = inventoryService.searchInventoryByForm(searchinventorydata);
	    inventoryList.addAll(inventory);	    
	    return new ResponseEntity<>(new CMRespDto<>(1, "성공", inventoryList), HttpStatus.OK);

	}

	
	@GetMapping("/inventory/searchTable")
	public ResponseEntity<?> searchInventory(
	    @RequestParam(name = "storageCodes", required = false) String storageCodes,
	    @RequestParam(name = "locationCodes", required = false) String locationCodes,
	    @RequestParam(name = "categorys", required = false) String categorys) {
	    List<InventoryDto> inventoryList = new ArrayList<>();
    	List<InventoryDto> inventory =inventoryService.searchInventoryByTable(locationCodes, storageCodes, categorys);	  
    	inventoryList.addAll(inventory);

	    return new ResponseEntity<>(new CMRespDto<>(1, "성공", inventoryList), HttpStatus.OK);
	}
}
