package com.dz.factory.storage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dz.factory.common.domain.Inventory;
import com.dz.factory.storage.dto.InventoryDto;
import com.dz.factory.storage.dto.InventoryForm;
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
	 public void TempInventoryRegistration(Inventory inventoryTemp){
	    	inventorymapper.TempInventoryRegistration(inventoryTemp);
	    };
	    
    public List<InventoryDto> searchInventoryByTable(String locationCodes, String storageCodes, String categorys) {
        return inventorymapper.searchInventoryByTable(locationCodes,  storageCodes, categorys);
    }
    public List<InventoryDto> searchInventoryByForm(InventoryForm searchinventorydata){
    	return inventorymapper.searchInventoryByForm(searchinventorydata);
    };

}
