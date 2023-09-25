package com.dz.factory.management.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.common.domain.Item;


@Mapper
public interface ItemMapper {

	ArrayList<Item> selAllItem();

	void insertItem(Item item);

	void deleteItem(String id);

	ArrayList<Item> selectSearchItem(HashMap<String, String> map);

	int updateItem(Item item);

	void insertUnitPrice(Item item);

	Item selSameOne(Item item);

}
