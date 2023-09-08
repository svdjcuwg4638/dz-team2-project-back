package com.dz.factory.storage.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

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
}
