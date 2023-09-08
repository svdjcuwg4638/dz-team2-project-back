package com.dz.factory.storage.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.storage.dto.Inventory;

@Mapper
public interface InventoryMapper {

	ArrayList<Inventory> selectInventoryAll();
}
