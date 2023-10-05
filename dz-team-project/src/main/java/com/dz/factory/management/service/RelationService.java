package com.dz.factory.management.service;

import java.util.ArrayList;

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
	public int RelationAdd(ProductRelation dto) {
		ProductRelation findItem = relationMapper.selSameOne(dto);
		int result = 1;
		if (dto.getItem_code().equals(dto.getComponent_code())) {
			return 2;
		}
		if (findItem != null) {
			if (findItem.getIsDelete() == 1) {
				findItem.setIsDelete(0);
				relationMapper.updateRelation(findItem);
			} else {
				result = 0;
			}
		} else {
			relationMapper.insertRelation(dto);
		}
		return result;
	}

	@Transactional
	public void RelationDel(ArrayList<ProductRelation> dtos) {
		for (ProductRelation dto : dtos) {
			relationMapper.deleteRelation(dto);
		}
	}

}
