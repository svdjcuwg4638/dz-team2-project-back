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
	public int itemAdd(Item item) {
		Item findItem = itemMapper.selSameOne(item);
		int result = 1;
		if(findItem != null) {
			if(findItem.getIsDelete() ==  1) {
				findItem.setIsDelete(0);
				itemMapper.updateItem(findItem);
			}else {
				result = 0;
			}
		}else {
			itemMapper.insertItem(item);
		}
		return result;
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

	@Transactional
	public int itemModify(Item item) {
		return itemMapper.updateItem(item);
	}
	
}
