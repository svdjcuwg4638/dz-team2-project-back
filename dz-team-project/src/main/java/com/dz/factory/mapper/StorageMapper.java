package com.dz.factory.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.dz.factory.domain.management.Storage;
import com.dz.factory.web.dto.management.LocationDto;

@Mapper
public interface StorageMapper {

	void insertStorage(Storage storage);

	ArrayList<Storage> selectAll();

	void insertLocation(LocationDto locationDto);

	ArrayList<LocationDto> selectLocationAll();

	void updateLocation(LocationDto locationDto);

	void deleteLocation(int id);

	void deleteStorage(int id);
	
}
