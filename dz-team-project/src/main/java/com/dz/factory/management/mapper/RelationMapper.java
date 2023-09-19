package com.dz.factory.management.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.common.domain.ProductRelation;

@Mapper
public interface RelationMapper {

	ArrayList<ProductRelation> getRelationAll();

	void insertRelation(ProductRelation dto);

	void deleteRelation(String id);

}
