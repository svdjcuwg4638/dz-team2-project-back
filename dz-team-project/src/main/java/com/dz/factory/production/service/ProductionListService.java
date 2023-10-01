package com.dz.factory.production.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.dz.factory.production.mapper.ProductionListMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductionListService {
	private final ProductionListMapper listMapper;

	public HashMap<String,ArrayList<?>> getProductionList(HashMap<String, ?> searchFilter) {
		
		ArrayList<HashMap<String, ?>> productionList = new ArrayList<>();

		ArrayList<Map.Entry<String, ?>> filterList = new ArrayList<>();
		for (Map.Entry<String, ?> entry : searchFilter.entrySet()) {
//			System.out.println(entry);
			if (entry.getKey().equals("date")
					|| entry.getKey().equals("description")
					|| entry.getKey().toLowerCase().contains("code"))
				filterList.add(entry);
		}

		productionList = listMapper.getProductionList(filterList);
		
		ArrayList<String> productionCode = new ArrayList<String>();
		for(HashMap<String,?> map : productionList) {
			productionCode.add((map.get("production_code")).toString());
		}
		ArrayList<ArrayList<ArrayList<?>>> componentList = listMapper.getComponentList(productionCode);
		
		HashMap<String,ArrayList<?>> result=new HashMap<String,ArrayList<?>>();
		result.put("production", productionList);
		result.put("component", componentList);
		
		return result;
	}

	public void updateProduction(HashMap<String, ?> searchFilter) {
		if (searchFilter.get("production") != null) {

		}
		if (searchFilter.get("component") != null) {

		}
		if (searchFilter.get("productDelete") != null) {

		}
	}
}
