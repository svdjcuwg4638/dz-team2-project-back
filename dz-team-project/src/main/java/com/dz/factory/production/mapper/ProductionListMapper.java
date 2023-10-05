package com.dz.factory.production.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.production.dto.ComponentDto;
import com.dz.factory.production.dto.ProductionDetailDto;
import com.dz.factory.production.dto.ProductionDto;

@Mapper
public interface ProductionListMapper {
	//내역조회
	public ArrayList<HashMap<String,?>> getProductionList(HashMap<String,?> searchFilter);
	public ArrayList<HashMap<String,?>> getComponentList(String code);
	
	//내역 수정
	public void updateProduction(ProductionDto productionDto);
	public void updateDetail(ProductionDetailDto detailDto);
	public void updateComponent(ComponentDto componentList);
	
	//내역 삭제
	public void deleteProduction(ProductionDto productionDto);

}
