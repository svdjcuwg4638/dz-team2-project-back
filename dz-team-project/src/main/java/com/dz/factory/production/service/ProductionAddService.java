package com.dz.factory.production.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dz.factory.common.domain.Item;
import com.dz.factory.production.dto.ProductRelationDto;
import com.dz.factory.production.mapper.ProductionAddMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductionAddService {

	private final ProductionAddMapper addMapper;
	
	public List<ProductRelationDto> getRelation(String itemCode){		
		//relation 조회
		ArrayList<ProductRelationDto> relationList = addMapper.getProductRelation(itemCode);
		return relationList;
	}
	
	public List<Item> getComponent(String itemCode) {
		
		List<Item> itemList = new ArrayList<>();
		
		List<ProductRelationDto> relationList = getRelation(itemCode);
		for(ProductRelationDto relation : relationList) {
			Item item = addMapper.getItemByCode(relation.getComponent_code());
			System.out.println(item);
			itemList.add(item);
		}
		return itemList;
		
	}
}






