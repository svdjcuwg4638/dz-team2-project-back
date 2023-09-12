package com.dz.factory.storage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dz.factory.common.domain.Location;
import com.dz.factory.common.domain.Storage;
import com.dz.factory.storage.dto.Inventory;
import com.dz.factory.storage.mapper.CodehelperMapper;
import com.dz.factory.storage.mapper.InventoryMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InventoryService {

	private final InventoryMapper inventorymapper; 
	
	public ArrayList<Inventory> getInventoryAll(){
		return inventorymapper.selectInventoryAll();
	}
	
	public List<Inventory> searchInventoryByStorage(String storageCodes) {
	        return inventorymapper.searchInventoryByStorage(storageCodes);
	    }


    public List<Inventory> searchInventoryByLocation(String locationCodes, String storageCodes) {
        return inventorymapper.searchInventoryByLocation(locationCodes,  storageCodes);
    }
    public List<Inventory> searchInventoryByCategory(String locationCodes, String storageCodes, String categorys) {
        return inventorymapper.searchInventoryByCategory(locationCodes,  storageCodes, categorys);
    }
//	public ArrayList<Inventory> searchByLoction(String storage, String location){
//		return inventorymapper.selectSearchInventorybyLocation(storage, location);
//	}
//	public ArrayList<Inventory> search(Storage storage){
//		return inventorymapper.selectSearchInventorybyStorage(storage);
//	}
}
