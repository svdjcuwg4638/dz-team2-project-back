package com.dz.factory.storage.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dz.factory.common.domain.CMRespDto;
import com.dz.factory.common.domain.Inventory;
import com.dz.factory.common.domain.Location;
import com.dz.factory.common.domain.Movement;
import com.dz.factory.common.domain.Storage;
import com.dz.factory.common.domain.TempInventory;
import com.dz.factory.storage.dto.InventoryDto;
import com.dz.factory.storage.dto.InventoryForm;
import com.dz.factory.storage.dto.MovementDto;
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

	@GetMapping("/inventory/registration/temp/all")
	public ResponseEntity<?> TempInventoryGetAll(){
		ArrayList<Inventory> inventoryList = inventoryService.getTempInventoryAll();
		System.out.println(inventoryList);
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",inventoryList),HttpStatus.OK);
	}
	
	@PostMapping("/inventory/registration/temp/add")
	public ResponseEntity<?> tempinventoryAdd(@RequestBody List<TempInventory> inventoryTempList){
		 if (inventoryTempList != null && !inventoryTempList.isEmpty()) {
			 inventoryService.TempInventoryDestory();
		        for (TempInventory inventoryTemp : inventoryTempList) {
		        	inventoryService.TempInventoryRegistration(inventoryTemp);	  
		        }		
		 }
		        return new ResponseEntity<>(new CMRespDto<>(1,"성공",inventoryTempList),HttpStatus.CREATED);
	}
	
	@PostMapping("/inventory/registration/add")
	public ResponseEntity<?> inventoryAdd(@RequestBody List<Inventory> inputInventoryList){
		if (inputInventoryList != null && !inputInventoryList.isEmpty()) {
	        ArrayList<InventoryDto> inventoryList = inventoryService.getInventoryAll();

	        for (Inventory inputInventory : inputInventoryList) {
	        	if(inputInventory.getStorage_code()!=null && inputInventory.getLocation_code()!=null && inputInventory.getItem_code()!=null)
	            	inventoryService.InventoryRegistrationUpdate(inputInventory);
	            } 
	    }
		        return new ResponseEntity<>(new CMRespDto<>(1,"성공",inputInventoryList),HttpStatus.CREATED);
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
	
	@PostMapping("/inventory/movement/add")
	public ResponseEntity<?> addMovement(@RequestBody List< Movement> movementList ){
		for(Movement movement : movementList) {
			if(movement.getOutbound_storage_code()!=null && movement.getOutbound_location_code()!=null &&
					movement.getInbound_storage_code()!=null && movement.getInbound_location_code()!=null &&
					movement.getItem_code()!=null ) {
				System.out.println(movement);

			 inventoryService.MovementUpdate("출고", movement.getOutbound_storage_code(), movement.getOutbound_location_code(), movement.getItem_code(), movement.getMovement());
			 inventoryService.MovementUpdate("입고", movement.getInbound_storage_code(), movement.getInbound_location_code(), movement.getItem_code(), movement.getMovement());
			 inventoryService.MovementInsert(movement);

			}
		
		}
 
	    return new ResponseEntity<>(new CMRespDto<>(1, "성공", movementList), HttpStatus.OK);
	}
	
	// 내역 조회 
	
	@GetMapping("/inventory/movement")
	public ResponseEntity<?> getMovement(   @RequestParam(name = "outbound_storage_code", required = false) String outbound_storage_code,
		    @RequestParam(name = "outbound_location_code", required = false) String outbound_location_code,
		    @RequestParam(name = "inbound_storage_code", required = false) String inbound_storage_code,
		    @RequestParam(name = "inbound_location_code", required = false) String inbound_location_code,
		    @RequestParam(name = "item_code", required = false) String item_code ){
		System.out.println(outbound_storage_code + outbound_location_code + inbound_storage_code + inbound_location_code + item_code);
		
		List <String> movementStock = new ArrayList<>();  
		 String movement1 = inventoryService.searchMovementStock(outbound_storage_code, outbound_location_code, item_code);
		 movementStock.add(movement1);

		 String movement2 = inventoryService.searchMovementStock(inbound_storage_code, inbound_location_code, item_code);
		 movementStock.add(movement2);
System.out.println(movementStock);
   
	    return new ResponseEntity<>(new CMRespDto<>(1, "성공", movementStock), HttpStatus.OK);
	}
	
	@GetMapping("/inventory/movement/search")
    public ResponseEntity<?> searchMovements(@RequestParam(name = "outbound_storage_code", required = false) String outboundStorageCode,
            @RequestParam(name = "outbound_location_code", required = false) String outboundLocationCode,
            @RequestParam(name = "inbound_storage_code", required = false) String inboundStorageCode,
            @RequestParam(name = "inbound_location_code", required = false) String inboundLocationCode,
            @RequestParam(name = "item_code", required = false) String itemCode,
            @RequestParam(name = "start_date", required = false) String startDate,
            @RequestParam(name = "end_date", required = false) String endDate,
            @RequestParam(name = "emp_id", required = false) String empId,
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {

			List<MovementDto> movements = inventoryService.searchMovements(outboundStorageCode,
			                    outboundLocationCode,
			                    inboundStorageCode,
			                    inboundLocationCode,
			                    itemCode,
			                    startDate,
			                    endDate,
			                    empId,
			                    page,
			                    pageSize);
			System.out.println(startDate+endDate);
			System.out.println(movements);
//		    if (movements == null || movements.isEmpty()) {
//		        // 검색 결과가 없을 때의 처리
//		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		    }
		    return new ResponseEntity<>(new CMRespDto<>(1, "성공", movements), HttpStatus.OK);
			}
	
	@GetMapping("/inventory/movement/totalcount")
	public ResponseEntity<?> getTotalCount(
	    @RequestParam(name = "outbound_storage_code", required = false) String outboundStorageCode,
	    @RequestParam(name = "outbound_location_code", required = false) String outboundLocationCode,
	    @RequestParam(name = "inbound_storage_code", required = false) String inboundStorageCode,
	    @RequestParam(name = "inbound_location_code", required = false) String inboundLocationCode,
	    @RequestParam(name = "item_code", required = false) String itemCode,
        @RequestParam(name = "start_date", required = false) String startDate,
        @RequestParam(name = "end_date", required = false) String endDate,
	    @RequestParam(name = "emp_id", required = false) String empId) {

	    int totalCount = inventoryService.countSearchMovements(
	        outboundStorageCode,
	        outboundLocationCode,
	        inboundStorageCode,
	        inboundLocationCode,
	        itemCode,
	        startDate, 
	        endDate, 
	        empId);

	    System.out.println("토탈카운트 " + totalCount);
	    return new ResponseEntity<>(new CMRespDto<>(1, "성공", totalCount), HttpStatus.OK);
	}
	
	}
			
