package com.dz.factory.storage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dz.factory.common.domain.Inventory;
import com.dz.factory.common.domain.Movement;
import com.dz.factory.common.domain.TempInventory;
import com.dz.factory.storage.dto.InventoryDto;
import com.dz.factory.storage.dto.InventoryForm;
import com.dz.factory.storage.dto.MovementDto;
import com.dz.factory.storage.mapper.InventoryMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InventoryService {

	private final InventoryMapper inventorymapper; 
	
	
	public ArrayList<InventoryDto> getInventoryAll(){
		return inventorymapper.selectInventoryAll();
	}
	public ArrayList<Inventory> getTempInventoryAll(){
		return inventorymapper.selectTempInventoryAll();
	}
	public void TempInventoryDestory(){
    	inventorymapper.TempInventoryDestory();
    };

	public void TempInventoryRegistration(TempInventory inventoryTemp){
    	inventorymapper.TempInventoryRegistration(inventoryTemp);
	    };
	    
    public void InventoryRegistrationUpdate(Inventory inventory){
    	inventorymapper.InventoryRegistrationUpdate(inventory); 
    }
    
    public List<InventoryDto> searchInventoryByTable(String locationCodes, String storageCodes, String categorys) {
        return inventorymapper.searchInventoryByTable(locationCodes,  storageCodes, categorys);
    }
    public List<InventoryDto> searchInventoryByForm(InventoryForm searchinventorydata){
    	return inventorymapper.searchInventoryByForm(searchinventorydata);
    };
    
    public String searchMovementStock(String storage_code, String location_code, String item_code) {
    	return inventorymapper.searchMovementStock(storage_code, location_code, item_code);
    }

    public void MovementUpdate(String type, String storage_code, String location_code, String item_code, int movement) {
    	inventorymapper.MovementUpdate(type, storage_code, location_code, item_code, movement);
    }
    
    public void MovementInsert(Movement movement) {
    	inventorymapper.MovementInsert(movement);

    }
    public List<MovementDto> searchMovements(String outboundStorageCode,
            String outboundLocationCode,
            String inboundStorageCode,
            String inboundLocationCode,
            String itemCode,
            String startDate,
            String endDate,
            String empId,
            int page,
            int pageSize) {
				int startRow = (page - 1) * pageSize;
				List<MovementDto> movements = inventorymapper.searchMovements(outboundStorageCode,
				                                    outboundLocationCode,
				                                    inboundStorageCode,
				                                    inboundLocationCode,
				                                    itemCode,
				                                    startDate, 
				                                    endDate,
				                                    empId,
				                                    startRow,
				                                    pageSize);
				return movements;
				}

public int countSearchMovements(String outboundStorageCode,
       String outboundLocationCode,
       String inboundStorageCode,
       String inboundLocationCode,
       String itemCode,
       String startDate, 
       String endDate,
       String empId) {
return inventorymapper.countSearchMovements(outboundStorageCode,
                     outboundLocationCode,
                     inboundStorageCode,
                     inboundLocationCode,
                     itemCode,
                     startDate,
                     endDate,
                     empId);
}
}
