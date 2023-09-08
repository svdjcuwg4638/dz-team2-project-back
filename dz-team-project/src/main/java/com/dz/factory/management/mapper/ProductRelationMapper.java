package com.dz.factory.management.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.common.domain.ProductRelation;

@Mapper
public interface ProductRelationMapper {

	void insert(ProductRelation insertData);
	
}
