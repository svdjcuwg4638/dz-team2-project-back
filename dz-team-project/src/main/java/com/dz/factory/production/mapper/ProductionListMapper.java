package com.dz.factory.production.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductionListMapper {
	public ArrayList<HashMap<String,?>> getListByDate(ArrayList<Entry<String,?>> filterList);
//	public HashMap<String,?> getListByDate(HashMap<String,?> searchFilter);
	public ArrayList<HashMap<String,?>> getList(HashMap<String,?> searchFilter);

}
