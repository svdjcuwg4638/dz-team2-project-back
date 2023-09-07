package com.dz.factory.management.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.common.domain.Location;
import com.dz.factory.common.domain.Storage;


@Mapper
public interface StorageMapper {

	void insertStorage(Storage storage);

	ArrayList<Storage> selectAll();

	void insertLocation(Location locationDto);

	ArrayList<Location> selectLocationAll();

	void updateLocation(Location locationDto);

	void deleteLocation(int id);

	void deleteStorage(String code);

	ArrayList<Storage> selSearchStorage(HashMap<String, String> formData);

	ArrayList<Storage> selSearchLocation(HashMap<String, String> formData);
	
}
