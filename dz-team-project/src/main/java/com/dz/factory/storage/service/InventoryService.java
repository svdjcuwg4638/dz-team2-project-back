package com.dz.factory.storage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dz.factory.common.domain.Location;
import com.dz.factory.common.domain.Storage;
import com.dz.factory.storage.dto.InventoryDto;
import com.dz.factory.storage.dto.InventoryForm;
import com.dz.factory.storage.mapper.CodehelperMapper;
import com.dz.factory.storage.mapper.InventoryMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InventoryService {

	private final InventoryMapper inventorymapper; 
	
	public ArrayList<InventoryDto> getInventoryAll(){
		return inventorymapper.selectInventoryAll();
	}
	
    public List<InventoryDto> searchInventoryByTable(String locationCodes, String storageCodes, String categorys) {
        return inventorymapper.searchInventoryByTable(locationCodes,  storageCodes, categorys);
    }
    public List<InventoryDto> searchInventoryByForm(InventoryForm searchinventorydata){
    	return inventorymapper.searchInventoryByForm(searchinventorydata);
    };

}
