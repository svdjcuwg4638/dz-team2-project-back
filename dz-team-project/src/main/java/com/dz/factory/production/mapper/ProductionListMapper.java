package com.dz.factory.production.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductionListMapper {
	public ArrayList<HashMap<String,?>> getProductionList(ArrayList<Entry<String,?>> filterList);
	public ArrayList<ArrayList<ArrayList<?>>> getComponentList(ArrayList<String> productionCode);
	

}
