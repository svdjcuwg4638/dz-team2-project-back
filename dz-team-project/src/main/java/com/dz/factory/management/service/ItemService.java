package com.dz.factory.management.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dz.factory.common.domain.Item;
import com.dz.factory.management.mapper.ItemMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ItemService {

	private final ItemMapper itemMapper;

	public ArrayList<Item> getAllItem() {
		return itemMapper.selAllItem();
	}

	@Transactional
	public void itemAdd(Item item) {
		itemMapper.insertItem(item);
	}

	@Transactional
	public void delItem(List<String> ids) {
		for(String id : ids) {
			itemMapper.deleteItem(id);
		}
	}

	public ArrayList<Item> getSearch(HashMap<String, String> map) {
		return itemMapper.selectSearchItem(map);
	}
	
}
