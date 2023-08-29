package com.dz.factory.management.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.common.domain.Storage;
import com.dz.factory.management.dto.LocationDto;


@Mapper
public interface StorageMapper {

	void insertStorage(Storage storage);

	ArrayList<Storage> selectAll();

	void insertLocation(LocationDto locationDto);

	ArrayList<LocationDto> selectLocationAll();

	void updateLocation(LocationDto locationDto);

	void deleteLocation(int id);

	void deleteStorage(String code);

	ArrayList<Storage> selSearchStorage(HashMap<String, String> formData);

	ArrayList<Storage> selSearchLocation(HashMap<String, String> formData);
	
}
