package com.dz.factory.management.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.management.domain.ProductRelation;
import com.dz.factory.management.dto.ProductRelationDto;
import com.dz.factory.management.mapper.ProductRelationMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductRelationService {

	private final ProductRelationMapper productRelationMapper;
	
	@Transactional
	public void productRelationAdd(ProductRelationDto dto) {
		
		for(ProductRelation component : dto.getComponents()) {
			ProductRelation insertData = new ProductRelation();
			insertData.setComponent_id(component.getItem_id());
			insertData.setQuantity(component.getQuantity());
			insertData.setItem_id(dto.getProductId());
			productRelationMapper.insert(insertData);
		}
		
	}
	
	
}
