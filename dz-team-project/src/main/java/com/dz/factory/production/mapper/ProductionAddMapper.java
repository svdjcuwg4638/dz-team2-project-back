package com.dz.factory.production.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.common.domain.Inventory;
import com.dz.factory.common.domain.Item;
import com.dz.factory.common.domain.ProductRelation;
import com.dz.factory.production.dto.ComponentDto;
import com.dz.factory.production.dto.ComponentItemDto;
import com.dz.factory.production.dto.ProductionDetailDto;
import com.dz.factory.production.dto.ProductionDto;
import com.dz.factory.production.dto.RelationDto;


@Mapper
public interface ProductionAddMapper {
	public ArrayList<ComponentItemDto> getComponentItems(String itemCode);
	public ArrayList<RelationDto> getRelation(String itemCode);
	public ArrayList<Inventory> getInventory(String itemCode,String storageCode, String locationCode);
	public void addProduction(ProductionDto productionDto);
	public void addDetail(ProductionDetailDto detailDto);
	public void addComponent(ArrayList<ComponentDto>componentList);
	public String getMaxProductionCode(String prefix);
}

