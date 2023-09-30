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

	public ArrayList<HashMap<String, ?>> getProductionList(HashMap<String, ?> searchFilter) {
		int length = searchFilter.size();
		ArrayList<HashMap<String, ?>> list = new ArrayList<>(length);

		ArrayList<Map.Entry<String, ?>> filterList = new ArrayList<>();

		for (Map.Entry<String, ?> entry : searchFilter.entrySet()) {
//			System.out.println(entry);
			if (entry.getKey().equals("date")
					|| entry.getKey().equals("description")
					|| entry.getKey().toLowerCase().contains("code"))
				filterList.add(entry);
		}

		list = listMapper.getListByDate(filterList);
		return list;
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
