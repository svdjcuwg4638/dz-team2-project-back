package com.dz.factory.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.common.domain.ProductRelation;
import com.dz.factory.management.mapper.RelationMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RelationService {

	private final RelationMapper relationMapper;

	public ArrayList<ProductRelation> getRelationAll() {
		return relationMapper.getRelationAll();
	}

	@Transactional
	public void RelationAdd(ProductRelation dto) {
		relationMapper.insertRelation(dto);
	}

	@Transactional
	public void RelationDel(List<String> ids) {
		
		for(String id : ids) {
			relationMapper.deleteRelation(id);
		}
	}
	
	
	
}
