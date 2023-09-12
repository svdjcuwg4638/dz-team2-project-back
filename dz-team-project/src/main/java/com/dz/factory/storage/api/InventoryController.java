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
//	@GetMapping("/inventory/search")
//	public ResponseEntity<?> searchInventory(@RequestParam  Map<String, String> params){
//		List<Inventory> inventoryList = new ArrayList<>();
//		if (params != null && !params.isEmpty()) {
//	        // params 맵에서 storageCodes 및 locationCodes 값을 추출합니다.
//	        String storageList = params.get("storageCodes");
//	        String locationList= params.get("locationCodes");
//	        
//	        List<String> storageCodes = Arrays.asList(storageList.split(","));
//	        List<String> locationCodes = Arrays.asList(locationList.split(","));
//	        
//	        for (String storage_code : storageCodes) {
//		        for (String location_code : locationCodes) {
//		        	inventoryService.searchByLocation(storage_code, location_code);
//		        }
//	        }
//		}
//				return new ResponseEntity<>(new CMRespDto<>(1,"성공",inventoryList),HttpStatus.OK);
//
//	}
	
	@GetMapping("/inventory/search")
	public ResponseEntity<?> searchInventory(
	    @RequestParam(name = "storageCodes", required = false) String storageCodes,
	    @RequestParam(name = "locationCodes", required = false) String locationCodes,
	    @RequestParam(name = "categorys", required = false) String categorys) {
	    List<Inventory> inventoryList = new ArrayList<>();

	    
	    if (storageCodes != null && !storageCodes.isEmpty() && (locationCodes == null || locationCodes.isEmpty())&&(categorys == null || categorys.isEmpty())) {
	    	List<Inventory> inventory =inventoryService.searchInventoryByStorage(storageCodes);	  
	    	inventoryList.addAll(inventory);
	    	}

	    if (storageCodes != null && !storageCodes.isEmpty() &&locationCodes != null && !locationCodes.isEmpty() &&(categorys == null || categorys.isEmpty())) {
	        // locationCodes를 사용하여 로케이션에 대한 검색 쿼리를 작성하고 실행
	    	List<Inventory> inventory =inventoryService.searchInventoryByLocation(locationCodes, storageCodes);	  
	    	inventoryList.addAll(inventory);

	    }
	    
	    if (storageCodes != null && !storageCodes.isEmpty() &&locationCodes != null && !locationCodes.isEmpty() && categorys != null || !categorys.isEmpty()) {
	    	List<Inventory> inventory =inventoryService.searchInventoryByCategory(locationCodes, storageCodes, categorys);	  
	    	inventoryList.addAll(inventory);

	    }

	    // 검색 결과를 inventoryList에 추가

	    return new ResponseEntity<>(new CMRespDto<>(1, "성공", inventoryList), HttpStatus.OK);
	}
}
