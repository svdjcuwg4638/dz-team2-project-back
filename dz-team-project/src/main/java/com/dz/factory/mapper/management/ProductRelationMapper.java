package com.dz.factory.mapper.management;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.domain.management.ProductRelation;

@Mapper
public interface ProductRelationMapper {

	void insert(ProductRelation insertData);
	
}
