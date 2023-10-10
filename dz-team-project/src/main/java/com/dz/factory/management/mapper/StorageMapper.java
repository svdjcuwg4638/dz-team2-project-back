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

	void storageIsDeleteTrue(String code);

	void locationIsDeleteTrue(Location dto);

	Storage storageSameOne(String storage_code);

	void updateStorage(Storage storage);

	Location locationSameOne(Location locationDto);

	String findStorageTotal(String code);

	String findLocationTotal(Location location);
}
