package com.dz.factory.production.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.common.domain.Item;
import com.dz.factory.production.dto.ProductRelationDto;


@Mapper
public interface ProductionAddMapper {
	public ArrayList<ProductRelationDto> getProductRelation(String itemCode);
	public Item getItemByCode(String itemCode);
	
}
