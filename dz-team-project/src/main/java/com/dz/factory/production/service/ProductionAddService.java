package com.dz.factory.production.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dz.factory.common.domain.Inventory;
import com.dz.factory.common.domain.Item;
import com.dz.factory.common.domain.ProductRelation;
import com.dz.factory.production.dto.ComponentItemDto;
import com.dz.factory.production.dto.RelationDto;
import com.dz.factory.production.mapper.ProductionAddMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductionAddService {

	private final ProductionAddMapper addMapper;
	
	//item 으로 필요한 것 전부 조회
	public List<ComponentItemDto> getComponentItems(String itemCode){		
		return addMapper.getComponentItems(itemCode);
	}
	
	//relation 조회
	public List<RelationDto> getRelation (String itemCode){
		return addMapper.getRelation(itemCode);
	};
	
	//재고 조회
	public List<Inventory> getInventory (String itemCode, String storageCode, String locationCode){
		return addMapper.getInventory(itemCode, storageCode, locationCode);
	}
	
}






